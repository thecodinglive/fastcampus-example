package info.thecodinglive.photoapp.storage.gcp;


import com.google.api.services.storage.model.StorageObject;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Component
@RequiredArgsConstructor
public class GCPStorageComponent {
    private static final String PROJECT_ID = "boot-sample1";
    private static final String BUCKET_NAME = "photosample-storage";

    private BlobInfo createBlobInfo(String bucketName, String objectName) {
        BlobId blobId = BlobId.of(bucketName, objectName);
        return BlobInfo.newBuilder(blobId).build();
    }


    public void uploadGcpStorage(String bucketName, String objectName, String filePath) {
        try {
            Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
            storage.create(createBlobInfo(bucketName, objectName), Files.readAllBytes(Paths.get(filePath)));
            LOG.info("file upload: {} uploaded to bucket {} as {}", filePath, bucketName, objectName);
        } catch (Exception e) {
            LOG.debug("error", e);
        }
    }


    public void uploadGcpStorageStream(String objectName, InputStream fileInput) {
        try {
            Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
            storage.create(createBlobInfo(BUCKET_NAME, objectName), fileInput.readAllBytes());
            LOG.info("file upload: {} uploaded to bucket {}",  BUCKET_NAME, objectName);
        } catch (Exception e) {
            LOG.debug("error", e);
        }
    }

    public void downloadGcpStroage(String bucketName, String objectName, String destPath) {
        try {
            Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
            Blob blob = storage.get(BlobId.of(bucketName, objectName));
            blob.downloadTo(Paths.get(destPath));

            LOG.info("file download: {} uploaded to bucket {} as {}", destPath, bucketName, objectName);
        } catch (Exception e) {
            LOG.debug("error", e);
        }
    }

    public void downloadGcpStroage(String objectName, HttpServletResponse response) {
        try {
            Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_ID).build().getService();
            Blob blob = storage.get(BlobId.of(BUCKET_NAME, objectName));
            response.setHeader("Content-Disposition", "attachment; filename=\"" + objectName + "\";");
            response.setHeader("Content-Transfer-Encoding", "binary");
            blob.downloadTo(response.getOutputStream());

            LOG.info("file download to bucket {} as {}", BUCKET_NAME, objectName);
        } catch (Exception e) {
            LOG.debug("error", e);
        }
    }
}
