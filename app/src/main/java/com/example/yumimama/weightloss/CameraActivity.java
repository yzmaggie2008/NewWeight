package com.example.yumimama.weightloss;

/**
 * Created by dyh on 2/8/18.
 */



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends Activity implements SurfaceHolder.Callback{
    SurfaceHolder surfaceHolder;
    SurfaceView surfaceView1;
    Button button1;
    ImageView imageView1;
    Camera camera;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_history:
                    Intent intent = new Intent(CameraActivity.this, history.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_information:
                    Intent intent1 = new Intent(CameraActivity.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.navigation_setting:
                    Intent intent2 = new Intent(CameraActivity.this, CameraActivity.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        button1=(Button)findViewById(R.id.button1);

        setRequestedOrientation(1);


        surfaceView1=(SurfaceView)findViewById(R.id.surfaceView1);
        imageView1=(ImageView)findViewById(R.id.imageView1);
        surfaceHolder=surfaceView1.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(this);
        button1.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {


                camera.autoFocus(afcb);

            }});

    }
    PictureCallback jpeg =new PictureCallback(){

        public void onPictureTaken(byte[] data, Camera camera) {

            Bitmap bmp=BitmapFactory.decodeByteArray(data, 0, data.length);

            imageView1.setImageBitmap(bmp);

            FileOutputStream fop;
            try {
                fop=new FileOutputStream("/sdcard/dd.jpg");

                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fop);

                fop.close();
                System.out.println("Successful!");

            } catch (FileNotFoundException e) {

                e.printStackTrace();
                System.out.println("FileNotFoundException");

            } catch (IOException e) {

                e.printStackTrace();
                System.out.println("IOException");
            }
            camera.startPreview();

        }

    };

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {


    }

    public void surfaceCreated(SurfaceHolder holder) {

        camera=Camera.open();
        try {

            Camera.Parameters parameters=camera.getParameters();
            parameters.setPictureFormat(PixelFormat.JPEG);
            parameters.setPreviewSize(320, 220);
            camera.setParameters(parameters);

            camera.setPreviewDisplay(surfaceHolder);

            camera.startPreview();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void surfaceDestroyed(SurfaceHolder holder) {

        System.out.println("surfaceDestroyed");
        camera.stopPreview();

        camera.release();

        //
    }


    AutoFocusCallback afcb= new AutoFocusCallback(){

        public void onAutoFocus(boolean success, Camera camera) {

            if(success){

                camera.takePicture(null, null, jpeg);
            }
        }


    };
}
