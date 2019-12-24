package com.example.fragmentodev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Version.VersionGonder{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void idAL(String name,String versiyon,String api) {
        Detail frag=Detail.newInstance(name,versiyon,api);
    getSupportFragmentManager().beginTransaction().replace(R.id.f_detail,frag).commit();
    }
}
