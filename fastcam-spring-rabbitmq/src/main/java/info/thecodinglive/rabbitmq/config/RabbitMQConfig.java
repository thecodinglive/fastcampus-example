package info.thecodinglive.rabbitmq.config;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import info.thecodinglive.rabbitmq.sample.model.MyTask;
import info.thecodinglive.utils.jackson.FastcamJacksonConverter;
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


@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @Resource
    private RabbitProperties rabbitProperties;

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
        connectionFactory.setAddresses(rabbitProperties.getAddresses());
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
            //	log.debug("queueName: {}", appRabbitQueue.getName());
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
        TopicExchange topicExchange = new TopicExchange("fastcam");
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
        rabbitTemplate.setExchange("cafe");

        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if(ack) {
                	//log.debug("ACK success");
            }else{
                	//log.debug("NAC:{}", cause);
            }
        }));

        return rabbitTemplate;
    }


}
