package info.thecodinglive.rabbitmq.config;

import info.thecodinglive.rabbitmq.sample.model.MyTask;
import info.thecodinglive.rabbitmq.sample.service.FastcamJacksonConverter;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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



}
