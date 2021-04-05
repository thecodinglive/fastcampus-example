package info.thecodinglive.photoapp.storage.gcp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class GcpStorageService {
    private final GCPStorageComponent gcpStorageComponent;

    public void gcpFileUpload(String uploadedFileName, MultipartFile multipartFile) {
        try {
            gcpStorageComponent.uploadGcpStorageStream(uploadedFileName, multipartFile.getInputStream());
        }catch (Exception e) {
            LOG.error("upload error", e);
        }
    }

    public void gcpFileDown(String gcpFileName, HttpServletResponse servletResponse) {
        gcpStorageComponent.downloadGcpStroage(gcpFileName, servletResponse);
    }
}
