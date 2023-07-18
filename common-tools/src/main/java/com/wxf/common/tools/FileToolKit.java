package com.wxf.common.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件工具类
 *
 * @author WangMaoSong
 * @version 1.1.0
 * @since 2023/5/18 16-29:25
 */
@Slf4j
public class FileToolKit {


    /**
     * 如果文件夹不存在则创建
     *
     * @param path 路径
     * @return 文件路径
     * @throws IOException 异常
     */
    public static Path mkdirIfNotExist(String path) throws IOException {
        return mkdirIfNotExist(Paths.get(path));
    }

    /**
     * 如果文件夹不存在则创建
     *
     * @param path 路径
     * @return 文件路径
     * @throws IOException 异常
     */
    public static Path mkdirIfNotExist(Path path) throws IOException {
        if (Files.exists(path)) {
           log.warn("current dir has exist");
           return path;
        }
        return Files.createDirectory(path);
    }
}
