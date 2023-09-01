package com.wxf.tenant.locks;


/**
 * 锁
 */
public interface ILock {

    /**
     * 尝试获取锁
     *
     * @param timeOutSec 超时时间
     * @return 是否获取锁
     */
    boolean tryLock(long timeOutSec) throws InterruptedException;

    /**
     * 释放锁
     */
    void unlock();
}
