package com.wxf.common.tools;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Json工具类
 *
 * @author WangMaoSong
 * @date 2022/8/29 13:33
 * @since 2.1.1
 */
public class JsonToolKit {


    public static void parse() {

    }

    /**
     * 将对象转换成字符串
     *
     * @param object 对象
     * @return 字符串
     */
    public static String toJSONString(Object object) {
        return JSONObject.toJSONString(object);
    }

    public static String toJSONString(Object object, SerializerFeature... features) {
        return JSONObject.toJSONString(object, features);
    }

    /**
     * 打印
     *
     * @param object 对象
     */
    public static void print(Object object) {
        System.out.println(toJSONString(object));
    }


    /**
     * 格式化对象
     *
     * @param text          文本
     * @param typeReference 包装类
     * @param features      属性
     * @param <T>           返回值类型
     * @return 格式化后的对象
     */
    public static <T> T parseObject(String text, TypeReference<T> typeReference, Feature... features) {
        return JSONObject.parseObject(text, typeReference, features);
    }


    /**
     * 格式化对象
     *
     * @param text  文本
     * @param clazz 包装类
     * @param <T>   返回值类型
     * @return 格式化后的对象
     */
    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSONObject.parseObject(text, clazz);
    }
}
