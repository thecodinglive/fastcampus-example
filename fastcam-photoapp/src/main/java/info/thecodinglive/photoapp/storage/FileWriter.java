package info.thecodinglive.photoapp.storage;

import info.thecodinglive.photoapp.config.PhotoAppProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class FileWriter {
    @Autowired
    PhotoAppProperties photoAppProperties;

    public long writeFile(MultipartFile multipartFile, String filePath) {
        try {
            multipartFile.transferTo(new File(filePath));
        } catch (IllegalStateException ile) {
          throw new RuntimeException("file write error");
        } catch (IOException ioe) {
            throw new RuntimeException("ioe error");
        }
        return multipartFile.getSize();
    }

    public String getFilePath(String fileId, MultipartFile sourceFile) {
        return photoAppProperties.getDefaultPath() +"/" + dateStr() + "/" + fileId + "." + getMimeType(sourceFile.getOriginalFilename());
    }


    private static String getMimeType(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }

    public static String dateStr() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(dateTimeFormatter);
    }
}
