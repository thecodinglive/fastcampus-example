package info.thecodinglive.rabbitmq.config;

import org.springframework.amqp.core.MessageProperties;

public class MessagePropertiesFactory {
    private String appId;
    private String cluterId;


    public MessageProperties create() {
        return new MessageProperties();
    }

    public MessageProperties create(String appId, String clusterId) {
        MessageProperties properties = new MessageProperties();
        properties.setClusterId(clusterId);
        properties.setAppId(appId);
        return properties;
    }


}
