package info.thecodinglive.photoapp;

import info.thecodinglive.photoapp.storage.gcp.GCPStorageComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GcpStorageServiceTest {
    @Autowired
    private GCPStorageComponent gcpUploadService;

    private String projectId = "boot-sample1";
    private String bucketName =  "photosample-storage";
    private String filePath = "src/main/resources/test.jpg";

    @Test
    public void gcpUpload() {
        gcpUploadService.uploadGcpStorage(bucketName, "ysj-test3.jpg", filePath);
    }

    @Test
    public void gcpDownload() {
        gcpUploadService.downloadGcpStroage(bucketName, "test.jpg", "src/main/resources/test-down.jpg");
    }

    @Test
    public void getFiletPath() throws Exception {
        Files.readAllBytes(Paths.get("src/main/resources/test.jpg"));
    }
}
