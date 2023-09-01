package com.wxf.tenant.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultLock implements ILock {

    private final ReentrantLock lock;

    public DefaultLock(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public boolean tryLock(long timeOutSec) throws InterruptedException {
        return lock.tryLock(timeOutSec, TimeUnit.SECONDS);
    }

    @Override
    public void unlock() {
        lock.unlock();
    }
}
