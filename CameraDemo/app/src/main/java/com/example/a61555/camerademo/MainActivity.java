package com.example.a61555.camerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int OPEN_SYSTEM_CMAERA = 1;
    final static int OPEN_SYSTEM_ALBUM = 2;
    //final static int CROP_PHOTO = 3;

    ImageView imageView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        Button btn_camera = (Button) findViewById(R.id.camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //构建隐式Intent
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //调用系统相机
                startActivityForResult(intent, OPEN_SYSTEM_CMAERA);
            }
        });
        Button btn_album = (Button) findViewById(R.id.album);
        btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, OPEN_SYSTEM_ALBUM);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == OPEN_SYSTEM_CMAERA) {
            if (data != null){
                Bundle extras = data.getExtras();
                //ExtraData extraData = data.getExtras().getParcelable("data");
                if(extras != null) {

                    Bitmap bitmap = (Bitmap) extras.getParcelable("data");
                    //保存照片
                    //Uri savedPhotoUri = saveBitmap(bitmap, "demo2");
                    //显示照片
                    imageView.setImageBitmap(bitmap);
                    Toast.makeText(this, "Take a Photo", Toast.LENGTH_SHORT).show();
                } else
                    return;
                //startImageZoom(savedPhotoUri);
            }else
                return;
        }

        if(requestCode == OPEN_SYSTEM_ALBUM) {
            if (data != null){
                //用户从图库选择图片后会返回所选图片的Uri
                Uri uri = data.getData();
                if(uri != null) {
                    imageView.setImageURI(uri);
                    Toast.makeText(this, "Selected a Pic", Toast.LENGTH_SHORT).show();
                } else
                    return;
            }else
                return;
        }

        /*if (requestCode == CROP_PHOTO) {
            if (data == null){
                return;
            }else{
                Bundle extras = data.getExtras();
                if (extras != null){
                    //获取到裁剪后的图像
                    Bitmap bm = extras.getParcelable("data");
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    imageView.setImageBitmap(bm);
                }
            }
        }*/
    }

    /**
     * 将Bitmap写入SD卡中的一个文件中,并返回写入文件的Uri
     * @param bm
     * @param filename
     * @return
     */
    /*private Uri saveBitmap(Bitmap bm, String filename) {
        //新建文件夹用于存放裁剪后的图片
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/demo");
        if (!tmpDir.exists()){
            boolean flag = tmpDir.mkdir();
        }
        //新建文件存储裁剪后的图片
        File img = new File(tmpDir.getAbsolutePath(), filename+".jpg");
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            boolean flag = bm.compress(Bitmap.CompressFormat.JPEG, 85, fos);
            Toast.makeText(this, "created a new file:"+flag, Toast.LENGTH_SHORT).show();
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
    /**
     * 通过Uri传递图像信息以供裁剪
     * @param uri
     */
    /*private void startImageZoom(Uri uri){
        //构建隐式Intent来启动裁剪程序
        Intent intent = new Intent("com.android.camera.action.CROP");
        //设置数据uri和类型为图片类型
        intent.setDataAndType(uri, "image*//*");
        //显示View为可裁剪的
        intent.putExtra("crop", true);
        //裁剪的宽高的比例为1:1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //输出图片的宽高均为150
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        //裁剪之后的数据是通过Intent返回
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_PHOTO);
    }*/
}
