package com.example.intentodev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    final int REQUEST_CODE=15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent=new Intent(MainActivity.this,ReturnActivity.class);
                startActivityForResult(returnIntent,REQUEST_CODE);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQUEST_CODE)
            if (resultCode == Activity.RESULT_OK) {
                String text = intent.getStringExtra("text");
                int uzunluk = intent.getIntExtra("uzunluk", 0);
                Toast.makeText(this, text + " toplam silinen " + uzunluk, Toast.LENGTH_SHORT).show();
            }
    }
}
