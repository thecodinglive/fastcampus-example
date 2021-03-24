package info.thecodinglive.rabbitmq.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

@NoArgsConstructor
@ToString(exclude = "DEFAULT_MSG")
public class MyTask {
    private String taskId;
    private String msg;

    @JsonIgnore
    private String DEFAULT_MSG = "you guys do something";

    public MyTask(String msg) {
        this.taskId = UUID.randomUUID().toString();
        this.msg = StringUtils.hasLength(msg) ? msg : DEFAULT_MSG;
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
