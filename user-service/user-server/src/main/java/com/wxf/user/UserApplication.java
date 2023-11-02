package com.wxf.user;

import com.wxf.user.netty.NettyServer;
import jakarta.annotation.PostConstruct;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication(
        scanBasePackages = {
                "com.wxf.user",
                "com.wxf.user.provider"
        }
)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }


//    @PostConstruct
//    public void starNettyServer() {
//        try {
//            new NettyServer(9999).start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
