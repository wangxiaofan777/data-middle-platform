package com.wxf.user.config.web.converters;

import com.wxf.commons.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转枚举
 *
 * @author WangXiaofan777
 * @since 2022/11/2 19:53
 */
public class StringToEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    private static final Map<Class<?>, Converter<String, ?>> CONVERTER_MAP = new HashMap<>(16);

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter converter = CONVERTER_MAP.get(targetType);
        if (converter == null) {
            converter = new StringToEnumConverter<>(targetType);
            CONVERTER_MAP.put(targetType, converter);
        }
        return converter;
    }


    static class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {

        private final Map<String, T> map = new HashMap<>(16);

        StringToEnumConverter(Class<T> enumType) {
            T[] constants = enumType.getEnumConstants();
            for (T e : constants) {
                map.put(String.valueOf(e.getCode()), e);
            }
        }

        @Override
        public T convert(String source) {
            T t = map.get(source);
            if (t == null) {
                throw new IllegalArgumentException("错误的参数");
            }
            return t;
        }
    }
}
