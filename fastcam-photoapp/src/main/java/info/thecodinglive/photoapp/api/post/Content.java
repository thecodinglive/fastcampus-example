package info.thecodinglive.photoapp.api.post;

import lombok.*;
import org.springframework.util.Assert;


@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Content {
    private String contentId;
    private String title;
    private String body;
    private String writerNickName;
    private PostImage attachImage;
}
