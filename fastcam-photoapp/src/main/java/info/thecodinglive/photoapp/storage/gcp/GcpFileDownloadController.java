package info.thecodinglive.photoapp.storage.gcp;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GcpFileDownloadController {
    private final GcpStorageService gcpStorageService;

    @ApiOperation("gcp 파일 다운로드")
    @GetMapping("/v1.0/gcp/download")
    public ResponseEntity<?> fileDownload(
            HttpServletResponse response,
            String downloadFileName) {
        gcpStorageService.gcpFileDown(downloadFileName, response);
        return ResponseEntity.ok("ok");
    }
}
