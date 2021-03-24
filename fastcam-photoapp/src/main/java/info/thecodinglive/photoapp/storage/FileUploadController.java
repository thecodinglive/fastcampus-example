package info.thecodinglive.photoapp.storage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Api
@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @ApiOperation("이미지 파일 업로드")
    @PostMapping("/v1.0/upload/image")
    public ImageFileUploadResult transfer(
            @RequestParam("userKey") String userKey,
            @RequestPart("imageFile") MultipartFile multipartFile) {
        ImageFile imageFile = fileUploadService.upload(multipartFile);
        return ImageFileUploadResult.builder()
                .fileName(imageFile.getFileName())
                .fileId(imageFile.getFileId())
                .fileSize(imageFile.getFileSize())
                .build();
    }
}
