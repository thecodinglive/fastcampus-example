package info.thecodinglive.photoapp.config;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Slf4j
@Configuration
public class MutlpartConfig {

    @Value("${photoapp.file.defaultPath}")
    public String defaultPath ="";

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setResolveLazily(true);
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        multipartResolver.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        //try {
            LOG.info("path:" + defaultPath);
            //multipartResolver.setUploadTempDir(new FileSystemResource(defaultPath));
       // } catch (IOException e) {
         //  LOG.error("init error", e);
        //}
        return multipartResolver;
    }


}
