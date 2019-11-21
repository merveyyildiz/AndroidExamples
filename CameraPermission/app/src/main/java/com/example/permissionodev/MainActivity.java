package com.example.permissionodev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 26;
    Button btn;
    ImageView imageView;
EditText phone;
    String phoneNumber;
final static int CAMERA_RESULT=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.gonder);
        phone=findViewById(R.id.number);
        imageView=findViewById(R.id.imageView3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               phoneNumber=phone.getText().toString();
               camera();
            }
        });
    }
    public void camera() {
     Intent cameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
         startActivityForResult(cameraIntent,CAMERA_REQUEST);
     else{
         ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, CAMERA_RESULT);
     }
        }
        protected void onActivityResult(int requestCode, int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode== CAMERA_REQUEST)
            if(resultCode== Activity.RESULT_OK){
                Bitmap photo=(Bitmap)intent.getExtras().get("data");
                imageView.setImageBitmap(photo);
            }
        }
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] granted){
        if(requestCode== CAMERA_RESULT)
            if(granted[0] == PackageManager.PERMISSION_GRANTED)
                camera();
        }

    }
