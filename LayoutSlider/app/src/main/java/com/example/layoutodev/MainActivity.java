package com.example.layoutodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button ileri,geri;
    TextView il,plaka,aciklama;
    ImageView img;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     ileri=findViewById(R.id.ileri);
     geri=findViewById(R.id.geri);
     il=findViewById(R.id.il);
     plaka=findViewById(R.id.plaka);
     img=findViewById(R.id.img);
     aciklama=findViewById(R.id.decr);
     final String[] iller=getResources().getStringArray(R.array.iller);
     final String[] plakalar=getResources().getStringArray(R.array.plakalar);
     final String[] imgAdlari=getResources().getStringArray(R.array.imageName);
     final String[] aciklamalar=getResources().getStringArray(R.array.aciklama);
     il.setText(iller[0]);
     plaka.setText(plakalar[0]);
     img.setImageResource(getResources().getIdentifier(imgAdlari[0],"drawable",getPackageName()));
    aciklama.setText(aciklamalar[0]);
     ileri.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             i++;
             il.setText(iller[i]);
             plaka.setText(plakalar[i]);
             aciklama.setText(aciklamalar[i]);
             img.setImageResource(getResources().getIdentifier(imgAdlari[i],"drawable",getPackageName()));
             if(i== iller.length-1)
                 ileri.setVisibility(View.INVISIBLE);
             geri.setVisibility(View.VISIBLE);
         }
     });
     geri.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             i--;
             il.setText(iller[i]);
             plaka.setText(plakalar[i]);
             aciklama.setText(aciklamalar[i]);
             img.setImageResource(getResources().getIdentifier(imgAdlari[i],"drawable",getPackageName()));
             ileri.setVisibility(View.VISIBLE);
             if(i==0)
                 geri.setVisibility(View.INVISIBLE);
         }
     });
    }
    };


