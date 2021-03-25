package info.thecodinglive.rabbitmq.config;

public enum FastcamRabbitQueue {
    SAMPLE_TASK("photo.sample"),
    READ("photo.read"),
    WRITE("photo.write"),
    EMPTY("photo.empty");

    private String queueName;

    FastcamRabbitQueue(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }

    public static FastcamRabbitQueue find(String name) {
        for (FastcamRabbitQueue queue : FastcamRabbitQueue.values()) {
            if (queue.getQueueName().equalsIgnoreCase(name)) {
                return queue;
            }
        }
        return FastcamRabbitQueue.EMPTY;
    }
}

