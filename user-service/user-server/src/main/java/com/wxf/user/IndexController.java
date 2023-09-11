package com.wxf.user;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Timed(value = "首页", description = "首页耗时", histogram = true)
    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }

}
