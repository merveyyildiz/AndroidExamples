package com.example.sqliteodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
EditText et_name, et_tel;
Button btn_add;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        et_name=findViewById(R.id.et_name);
        et_tel=findViewById(R.id.et_tel);
        btn_add=findViewById(R.id.ekle);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper= new DatabaseHelper(getApplicationContext());
                String name= et_name.getText().toString();
                String tel=et_tel.getText().toString();
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(tel)){
                    databaseHelper.insertContact(name,tel);
                    Toast.makeText(InsertActivity.this, "Başarı ile eklenmiştir.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(InsertActivity.this, "Lütfen tüm alanları doldurunuz ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
