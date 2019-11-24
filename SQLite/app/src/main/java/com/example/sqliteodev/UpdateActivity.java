package com.example.sqliteodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText et_name,et_tel;
    Button btn_update;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        et_name=findViewById(R.id.new_name);
        et_tel=findViewById(R.id.new_tel);
        btn_update=findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                String tel=et_tel.getText().toString();
                databaseHelper= new DatabaseHelper(UpdateActivity.this);
                int id=getIntent().getIntExtra("Id",0);
                databaseHelper.updateConcat(id,name,tel);
                Toast.makeText(UpdateActivity.this, "Güncelleme başarı ile gerçekleşmiştir", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
