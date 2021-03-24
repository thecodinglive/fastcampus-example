package info.thecodinglive.rabbitmq.config;

public enum FastcamRabbitQueue {
    SAMPLE_TASK("fastcam.sample", 10000, 3),
    EMPTY("fastcam.empty", 0, 0);

    private String queueName;
    private int retryDelayTimeMs;
    private int retryCount;

    FastcamRabbitQueue(String queueName, int retryDelayTimeMs, int retryCount) {
        this.queueName = queueName;
        this.retryDelayTimeMs = retryDelayTimeMs;
        this.retryCount = retryCount;
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

    public static boolean invalid(String name) {
        return FastcamRabbitQueue.EMPTY.equals(find(name));
    }
}
