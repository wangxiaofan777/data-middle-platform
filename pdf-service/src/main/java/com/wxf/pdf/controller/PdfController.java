package com.wxf.pdf.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Wxf
 * @since 2024-02-21 15:00:20
 **/
@RestController
@RequestMapping("/pdf")
public class PdfController {


    @GetMapping("/preview")
    public void previewPdf(HttpServletResponse response) throws IOException {
        response.reset();
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        ServletOutputStream outputStream = response.getOutputStream();


        FileChannel fileChannel = FileChannel.open(Paths.get("/Users/wangmaosong/神舟信息/分贝通APP操作手册.pdf"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while ((fileChannel.read(byteBuffer)) != -1) {
            // 切换成读模式
            byteBuffer.flip();

            byte[] array = byteBuffer.array();
            outputStream.write(array, 0, array.length);

            // 清空buffer
            byteBuffer.clear();
        }

        // 写入到前端
        outputStream.flush();
    }
}
