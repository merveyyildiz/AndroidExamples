package com.example.intentodev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReturnActivity extends AppCompatActivity {
    Button btnGonder;
    EditText text;
    int uzunluk;
    String clearText,dirtyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        btnGonder=findViewById(R.id.btn_gonder);
        text=findViewById(R.id.et_txt);

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          dirtyText =text.getText().toString();
          int uz1=dirtyText.length();
          clearText=dirtyText.replaceAll("[^A-Za-z]","");
          uzunluk= uz1-(clearText.length());
          Intent sendIntent= new Intent();
          sendIntent.putExtra("text",clearText);
          sendIntent.putExtra("uzunluk",uzunluk);
          setResult(Activity.RESULT_OK,sendIntent);
          finish();
            }

        });

    }

}

