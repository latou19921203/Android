package com.example.a61555.pickpicturedemo.tool;

/**
 * Created by 61555 on 2017/12/13.
 */

abstract class PickPictureThread extends Thread implements Runnable {
    public abstract void pickPictureThreadRun();
    @Override
    public void run() {
        pickPictureThreadRun();
    }
}
