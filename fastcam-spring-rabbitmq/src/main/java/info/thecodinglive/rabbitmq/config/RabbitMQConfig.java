package info.thecodinglive.rabbitmq.config;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import info.thecodinglive.rabbitmq.sample.model.MyTask;
import info.thecodinglive.utils.jackson.FastcamJacksonConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.amqp.support.converter.MessagingMessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;


@Slf4j
@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @Resource
    private RabbitProperties rabbitProperties;

    public static final String RABBIT_EXECHAGNGE_NAME = "thecodinglive";
    private static final Integer CONSUMER_COUNT = 5;

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("myTask", MyTask.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }

    @Bean
    public MessageConverter rabbitMessageConverter() {
        Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter(FastcamJacksonConverter.getInstance());
        jsonConverter.setClassMapper(classMapper());
        return jsonConverter;
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        LOG.info("userName:: {}", rabbitProperties.getUsername());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory rabbitConnectionFactory) {
        final RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitConnectionFactory);
        rabbitAdmin.afterPropertiesSet();
        return rabbitAdmin;
    }

    @Bean
    List<Queue> rabbitQueues() {
        List<Queue> rabbitQueues = new ArrayList<>();
        QueueProperties queueProperties = new QueueProperties();

        for (FastcamRabbitQueue fastcamRabbitQueue : FastcamRabbitQueue.values()) {
            rabbitQueues.add(new Queue(fastcamRabbitQueue.getQueueName(), queueProperties.durable, queueProperties.exclusive, queueProperties.autoDelete));
        }
        return rabbitQueues;
    }

    private static class QueueProperties {
        private boolean durable = true;
        private boolean exclusive = false;
        private boolean autoDelete = false;
    }


    @Bean
    TopicExchange rabbitExchange(RabbitAdmin rabbitAdmin) {
        TopicExchange topicExchange = new TopicExchange(RABBIT_EXECHAGNGE_NAME);
        topicExchange.setAdminsThatShouldDeclare(rabbitAdmin);
        return topicExchange;
    }

    @Bean
    List<Binding> bindings(List<Queue> rabbitQueues, TopicExchange rabbitExchange) {
        return rabbitQueues.stream()
                .map(rabbitQueue -> BindingBuilder.bind(rabbitQueue).to(rabbitExchange).with(rabbitQueue.getName()))
                .collect(Collectors.toList());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnectionFactory,
                                         MessageConverter rabbitMessageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(rabbitConnectionFactory);
        rabbitTemplate.setMessageConverter(rabbitMessageConverter);
        rabbitTemplate.setExchange(RABBIT_EXECHAGNGE_NAME);

        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if(ack) {
                	LOG.info("success");
            }else{
                	LOG.error("error {}", cause);
            }
        }));

        return rabbitTemplate;
    }

    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        return factory;
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory());
        factory.setMessageConverter(rabbitMessageConverter());
        factory.setConcurrentConsumers( CONSUMER_COUNT );
        factory.setAutoStartup(Boolean.TRUE);

        return factory;
    }

}
