package kr.co.grpcexam.streaming.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

@Controller
public class ProgressiveDownloadController {

    private final String DIR = "static/videos/";
    private final ResourceLoader resourceLoader;

    public ProgressiveDownloadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/download")
    public StreamingResponseBody stream(HttpServletRequest req,
                                        @RequestParam("fileName") String fileName) throws Exception {
//        System.out.println("FILE_DIR=" + DIR);
//        System.out.println("fileName=" + fileName);
        // 1. src/main/resources/
        // 2. ClassPathResource
//        Resource resource = new ClassPathResource(DIR + fileName);
//        File file = resource.getFile();
        // 3. ResourceLoader
//        Resource resource = resourceLoader.getResource("classpath:" + DIR + fileName);
//        File file = resource.getFile();
        // 4. ResourceUtils
        File file = ResourceUtils.getFile("classpath:" + DIR + fileName);

        final InputStream is = new FileInputStream(file);

        return os -> {
            readAndWrite(is, os);
        };
    }

    private void readAndWrite(final InputStream is, OutputStream os) throws IOException {
        byte[] data = new byte[2048];
        int read = 0;
        while ((read = is.read(data)) > 0) {
            os.write(data, 0, read);
        }
        os.flush();
    }
}
