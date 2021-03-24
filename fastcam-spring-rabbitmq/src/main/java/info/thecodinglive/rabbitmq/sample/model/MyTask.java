package info.thecodinglive.rabbitmq.sample.model;

import java.util.UUID;

public class MyTask {
    private String taskId;
    private String msg;

    public MyTask(String msg) {
        this.taskId = UUID.randomUUID().toString();
        this.msg = msg;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
