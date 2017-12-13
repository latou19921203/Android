package com.example.a61555.pickpicturedemo.tool;

import android.os.Handler;
import android.os.Message;

import java.util.List;

/**
 * Created by 61555 on 2017/12/13.
 */

class PickPictureHandler extends Handler {
    final static int SCAN_OK = 1;
    final static int SCAN_ERROR = 2;

    private PickPictureCallback mCallback;

    public PickPictureHandler(PickPictureCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SCAN_OK:
                List<PictureTotal> list = (List<PictureTotal>) msg.obj;
                mCallback.onSuccess(list);
                break;
            case SCAN_ERROR:
                mCallback.onError();
                break;
        }
    }
}
