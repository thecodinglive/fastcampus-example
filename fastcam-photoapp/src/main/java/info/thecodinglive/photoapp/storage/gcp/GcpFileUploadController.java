package info.thecodinglive.photoapp.storage.gcp;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GcpFileUploadController {
    private final GcpStorageService gcpStorageService;

    @ApiOperation("gcp 파일 업로드")
    @PostMapping("/v1.0/gcp/upload")
    public ResponseEntity<?> fileupload(@RequestPart("imageFile") MultipartFile multipartFile) {
        gcpStorageService.gcpFileUpload(multipartFile.getOriginalFilename(), multipartFile);

        return ResponseEntity.ok("ok");
    }
}
