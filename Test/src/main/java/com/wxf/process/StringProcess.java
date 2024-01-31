package com.wxf.process;

/**
 * 字符串处理器
 *
 * @author Wxf
 * @since 2024-01-31 15:07:50
 **/
public class StringProcess extends AbstractProcess<String> {

    @Override
    protected boolean validate(String data) {
        System.out.println("Validating String  data..");
        return false;
    }

    @Override
    protected String processData(String data) {
        System.out.println("Processing String  data..");
        return null;
    }
}
