package com.wxf.pdf.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Pdf Service
 *
 * @author Wxf
 * @since 2024-02-21 16:52:53
 **/
public interface IPdfService {


    /**
     * 预览Pdf文件
     *
     * @param response response
     * @param filename 文件名
     */
    void previewPdf(HttpServletResponse response, String filename) throws IOException;
}
