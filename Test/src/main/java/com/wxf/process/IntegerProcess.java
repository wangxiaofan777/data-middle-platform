package com.wxf.process;

/**
 * 数字处理器
 *
 * @author Wxf
 * @since 2024-01-31 15:08:29
 **/
public class IntegerProcess extends AbstractProcess<Integer> {

    @Override
    protected boolean validate(Integer data) {
        System.out.println("Validating Integer  data..");
        return true;
    }

    @Override
    protected Integer processData(Integer data) {
        System.out.println("Processing data...");
        return data * 2;
    }
}
