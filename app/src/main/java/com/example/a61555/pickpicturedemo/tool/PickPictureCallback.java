package com.example.a61555.pickpicturedemo.tool;

import java.util.List;

/**
 * Created by 61555 on 2017/12/13.
 */

public interface PickPictureCallback {
    void onStart();

    void onSuccess(List<PictureTotal> list);

    void onError();
}
