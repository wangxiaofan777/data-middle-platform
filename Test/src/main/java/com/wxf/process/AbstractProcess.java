package com.wxf.process;

/**
 * 模板方法抽象类
 *
 * @author Wxf
 * @since 2024-01-31 14:53:57
 **/
public abstract class AbstractProcess<T> {


    // 定义模版方法骨架
    public final void process(T data) {
        validate(data);

        T processData = processData(data);

        postProcess(processData);

    }

    protected abstract boolean validate(T data);

    protected abstract T processData(T data);

    protected void postProcess(T data) {

    }
}
