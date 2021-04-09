package info.thecodinglive.photoapp.storage;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.util.UUID;

@Slf4j
@Service
public class FileUploadService {
    @Autowired
    private FileWriter fileWriter;

    public ImageFile upload(MultipartFile sourceFile) {
        String fileId = UUID.randomUUID().toString();
        String filePath = fileWriter.getFilePath(fileId, sourceFile);
        LOG.info("filePath:: {}", filePath );
        fileWriter.writeFile(sourceFile, filePath);

        return ImageFile.builder()
                .fileName(sourceFile.getName())
                .filePath(filePath)
                .fileId(fileId)
                .fileSize(sourceFile.getSize())
                .build();
    }
}
