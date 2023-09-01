package com.wxf.tenant.locks;

public class ZookeeperLock implements ILock{

    @Override
    public boolean tryLock(long timeOutSec) {
        return false;
    }

    @Override
    public void unlock() {

    }
}
