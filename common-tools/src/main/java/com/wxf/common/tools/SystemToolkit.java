package com.wxf.common.tools;

import java.util.Locale;
import java.util.Objects;

/**
 * 系统工具
 *
 * @author WangXiaofan777
 * @date 2022/11/16 17:21
 */
public class SystemToolkit {


    /**
     * 判断当前系统是否是Windows
     *
     * @return 当前系统是否是Windows
     */
    public static boolean isWindows() {
        String osName = System.getProperty("os.name");
        return Objects.nonNull(osName) && osName.toLowerCase(Locale.ROOT).startsWith("win");
    }

    /**
     * 判断当前系统是否是Linux
     *
     * @return 当前系统是否是Linux
     */
    public static boolean isLinux() {
        return !isWindows();
    }


}
