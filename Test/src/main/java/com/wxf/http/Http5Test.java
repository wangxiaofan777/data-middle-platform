package com.wxf.http;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.BasicHttpClientConnectionManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Http5测试
 *
 * @author Wxf
 * @since 2024-02-05 09:27:10
 **/
public class Http5Test {

    public static void main(String[] args) throws IOException {
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                // 建立连接超时时间
                .setConnectTimeout(60 , TimeUnit.SECONDS)
                // 建立连接后等待数据、两个数据包之间的间隔时间
                .setSocketTimeout(180, TimeUnit.SECONDS)
                .build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(60L, TimeUnit.SECONDS)
                .build();

        BasicHttpClientConnectionManager manager = new BasicHttpClientConnectionManager();
        manager.setConnectionConfig(connectionConfig);

        CloseableHttpClient client = HttpClientBuilder.create()
                .setConnectionManager(manager)
                .build();

        HttpGet httpGet = new HttpGet("http://github.com");
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = client.execute(httpGet);

        System.out.println(response.getCode());

    }
}
