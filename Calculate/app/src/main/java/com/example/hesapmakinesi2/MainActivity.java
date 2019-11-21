package com.example.hesapmakinesi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;

double sayi1,sonuc,sayi2;
String durum="";
String text;
Button bir,iki,uc,dort,bes,alti,yedi,sekiz,dokuz,sifir,topla,carp,cikar,bol,esittir,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        bir=findViewById(R.id.btn1);
        iki=findViewById(R.id.btn2);
        uc=findViewById(R.id.btn3);
        dort=findViewById(R.id.btn4);
        bes=findViewById(R.id.btn5);
        alti=findViewById(R.id.btn6);
        yedi=findViewById(R.id.btn7);
        sekiz=findViewById(R.id.btn8);
        dokuz=findViewById(R.id.btn9);
        sifir=findViewById(R.id.btn0);
        topla=findViewById(R.id.btntopla);
        cikar=findViewById(R.id.btncikar);
        carp=findViewById(R.id.btncarp);
        bol=findViewById(R.id.btnbol);
        esittir=findViewById(R.id.btnesit);
        c=findViewById(R.id.btnsil);
        bir.setOnClickListener(this);
        iki.setOnClickListener(this);
        uc.setOnClickListener(this);
        dort.setOnClickListener(this); bes.setOnClickListener(this);
        alti.setOnClickListener(this);
        yedi.setOnClickListener(this);
        sekiz.setOnClickListener(this);
        dokuz.setOnClickListener(this);
        sifir.setOnClickListener(this);
        topla.setOnClickListener(this);
        cikar.setOnClickListener(this);
        carp.setOnClickListener(this);
        esittir.setOnClickListener(this);
        c.setOnClickListener(this);
        bol.setOnClickListener(this);



        editText=findViewById(R.id.editText);


}

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btn0:
                editText.setText(editText.getText()+"0");
                break;
            case R.id.btn1:
                editText.setText(editText.getText()+"1");
                break;
            case R.id.btn2:
                editText.setText(editText.getText()+"2");
                break;
            case R.id.btn3:
                editText.setText(editText.getText()+"3");
                break;
            case R.id.btn4:
                editText.setText(editText.getText()+"4");
                break;
            case R.id.btn5:
                editText.setText(editText.getText()+"5");
                break;
            case R.id.btn6:
                editText.setText(editText.getText()+"6");
                break;
            case R.id.btn7:
                editText.setText(editText.getText()+"7");
                break;
            case R.id.btn8:
                editText.setText(editText.getText()+"8");
                break;
            case R.id.btn9:
                editText.setText(editText.getText()+"9");
                break;
            case R.id.btntopla:
                sayi1=Double.parseDouble(editText.getText().toString());
                editText.setText("");
                durum="topla";
                break;
            case R.id.btncikar:
                sayi1=Double.parseDouble(editText.getText().toString());
                editText.setText("");
                durum="cikar";
                break;
            case R.id.btncarp:
                sayi1=Double.parseDouble(editText.getText().toString());
                editText.setText("");
                editText.setText("");
                durum="carp";
                break;
            case R.id.btnbol:
                sayi1=Double.parseDouble(editText.getText().toString());
                editText.setText("");
                durum="bol";
                break;
            case R.id.btnsil:
                editText.setText("");
                break;
            case R.id.btnesit:
                sayi2=Double.parseDouble(editText.getText().toString());
                editText.setText("");
                if(durum.equals("topla"))
                    sonuc=sayi1+sayi2;
                else if(durum.equals("cikar"))
                    sonuc=sayi1-sayi2;
                else if(durum.equals("carp"))
                    sonuc=sayi1*sayi2;
                else if(durum.equals("bol"))
                    if(sayi1!=0 && sayi2!=0)
                        sonuc=sayi1/sayi2;
                    else {
                        sayi1 = 0;
                        editText.setText(" ");
                        Toast.makeText(this, "0 bölme hatası", Toast.LENGTH_SHORT).show();
                        break;
                    }editText.setText(String.valueOf(sonuc));
                sayi2=0;
                sayi1=0;
                sonuc=0;
                durum="";
        }
    }
}

