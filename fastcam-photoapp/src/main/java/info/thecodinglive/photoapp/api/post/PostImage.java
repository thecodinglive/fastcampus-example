package info.thecodinglive.photoapp.api.post;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostImage {
    private String fileName;
    private String path;
    private Integer width;
    private Integer height;
}
