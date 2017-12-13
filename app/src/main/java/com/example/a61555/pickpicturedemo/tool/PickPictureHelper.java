package com.example.a61555.pickpicturedemo.tool;

import android.content.Context;

import java.util.List;

/**
 * Created by 61555 on 2017/12/13.
 */

public class PickPictureHelper {
    private PickPicture mPickPicture;

    private PickPictureHelper(Context context, PickPictureCallback callback) {
        mPickPicture = new PickPicture(context.getApplicationContext(), callback);
        mPickPicture.start();
    }

    /**
     * 开始读取相册
     *
     * @param context
     * @param callback
     * @return
     */
    public static PickPictureHelper readPicture(Context context, PickPictureCallback callback) {
        callback.onStart();
        return new PickPictureHelper(context, callback);
    }

    /**
     * 取出子目录图片路径集合
     *
     * @param position
     * @return
     */
    public List<String> getChildPathList(int position) {
        if (mPickPicture == null) return null;
        return mPickPicture.getChildPathList(position);
    }
}
