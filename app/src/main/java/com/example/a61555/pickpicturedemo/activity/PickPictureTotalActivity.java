package com.example.a61555.pickpicturedemo.activity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a61555.pickpicturedemo.R;
import com.example.a61555.pickpicturedemo.adapter.PickPictureTotalAdapter;
import com.example.a61555.pickpicturedemo.tool.PickPictureCallback;
import com.example.a61555.pickpicturedemo.tool.PickPictureHelper;
import com.example.a61555.pickpicturedemo.tool.PictureTotal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 61555 on 2017/12/13.
 */

public class PickPictureTotalActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SELECT_PICTURE = 102;
    public static final int REQUEST_CODE_SELECT_ALBUM = 104;
    public static final String EXTRA_PICTURE_PATH = "picture_path";
    public static final String PERMISSION = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final int REQUEST_CODE_PICK_PICTURE = 100;

    private ProgressDialog mProgressDialog;
    private ListView mListView;
    private PickPictureHelper pickPictureHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_picture_total);
        mListView = (ListView) findViewById(R.id.pick_picture_total_listView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                List<String> childList = pickPictureHelper.getChildPathList(position);
                PickPictureActivity.gotoActivity(PickPictureTotalActivity.this, (ArrayList<String>) childList);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, PERMISSION) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(this, new String[]{PERMISSION}, REQUEST_CODE_PICK_PICTURE);
                    return;
                }
            } else
                getPicture();
        } else
            getPicture();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_CODE_PICK_PICTURE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    getPicture();
                else
                    Log.e("[PickPictureTotal]", "Failed");
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onPause() {
        //mProgressDialog.dismiss();
        super.onPause();
    }

    /**
     * 利用ContentProvider扫描手机中的图片，此方法在运行在子线程中
     */
    private void getPicture() {
        pickPictureHelper = PickPictureHelper.readPicture(this, new PickPictureCallback() {
            @Override
            public void onStart() {
                //显示进度条
                mProgressDialog = ProgressDialog.show(PickPictureTotalActivity.this, null, "正在加载");
            }

            @Override
            public void onSuccess(List<PictureTotal> list) {
                mProgressDialog.dismiss();
                mListView.setAdapter(new PickPictureTotalAdapter(PickPictureTotalActivity.this, list));
            }

            @Override
            public void onError() {
                mProgressDialog.dismiss();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_CANCELED && resultCode == Activity.RESULT_OK) {
            if (requestCode == PickPictureTotalActivity.REQUEST_CODE_SELECT_ALBUM) {
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        }
    }

    public static void gotoActivity(Activity activity) {
        Intent intent = new Intent(activity, PickPictureTotalActivity.class);
        activity.startActivityForResult(intent, REQUEST_CODE_SELECT_PICTURE);
    }
}
