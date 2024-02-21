package com.wxf.pdf.service.impl;

import com.wxf.pdf.service.IPdfService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Pdf Service 实现
 *
 * @author Wxf
 * @since 2024-02-21 16:53:20
 **/
@Service
public class PdfServiceImpl implements IPdfService {

    @Override
    public void previewPdf(HttpServletResponse response, String filename) throws IOException {
        response.reset();
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        ServletOutputStream outputStream = response.getOutputStream();

        FileChannel fileChannel = FileChannel.open(Paths.get(filename), StandardOpenOption.READ);

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
