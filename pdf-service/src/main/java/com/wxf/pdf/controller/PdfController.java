package com.wxf.pdf.controller;

import com.wxf.pdf.service.IPdfService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Wxf
 * @since 2024-02-21 15:00:20
 **/
@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Resource
    private IPdfService pdfService;


    /**
     * 预览文件
     *
     * @param response response
     * @param filename 文件名
     * @throws IOException 异常
     */
    @GetMapping("/preview/{filename}")
    public void previewPdf(HttpServletResponse response,
                           @PathVariable("filename") String filename) throws IOException {
        this.pdfService.previewPdf(response, filename);
    }
}
