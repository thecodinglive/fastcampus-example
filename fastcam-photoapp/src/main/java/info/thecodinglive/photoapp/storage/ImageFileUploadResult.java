package info.thecodinglive.photoapp.storage;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ImageFileUploadResult {
    private String fileId;
    private String fileName;
    private Long fileSize;
}
