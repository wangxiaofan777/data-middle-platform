package com.wxf.process;

/**
 * 模板方法测试
 *
 * @author Wxf
 * @since 2024-01-31 15:12:56
 **/
public class TemplateProcessMain {

    public static void main(String[] args) {
        StringProcess stringProcess = new StringProcess();
        stringProcess.processData("wms");

        IntegerProcess integerProcess = new IntegerProcess();
        integerProcess.process(1);
    }
}
