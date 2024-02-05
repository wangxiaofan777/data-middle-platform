package com.wxf;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @author Wxf
 * @since 2024-02-05 09:56:03
 **/
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "2");



        CompletableFuture.allOf(f1, f2);


    }
}
