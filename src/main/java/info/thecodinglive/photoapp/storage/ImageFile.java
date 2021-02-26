package info.thecodinglive.photoapp.storage;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageFile {
    private String fileId;
    private Long fileSize;
    private String fileName;
    private String fileType;
    private String filePath;
}
