package com.example.sqliteodev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv_person;
    DatabaseHelper databaseHelper;
    int selectid = 0;
    String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_person = findViewById(R.id.list_view);

        databaseHelper = new DatabaseHelper(MainActivity.this);
        listele();
        lv_person.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = lv_person.getItemAtPosition(position).toString();
                // - Göre bölüyoruz
                String[] itemBol = item.split(" - ");
                // id'mizi alıyoruz
                selectid = Integer.valueOf(itemBol[0]);
                tel=String.valueOf(itemBol[2]);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.new_contact:
                Intent insert = new Intent(this, InsertActivity.class);
                startActivity(insert);
                listele();
                return true;
            case R.id.update_contact:
                Intent update = new Intent(this, UpdateActivity.class);
                update.putExtra("Id",selectid);
                startActivity(update);
                listele();
                return true;
            case R.id.call_contact:
                call();
                return true;
            case R.id.delete_contact:
                databaseHelper.deleteContact(selectid);
                listele();
                return true;
        }
        return true;
    }

    public void call() {
        Intent callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+tel));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
            startActivity(callIntent);
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},25);
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int [] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(requestCode == 25)
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
                call();
            else
                Toast.makeText(this, "Arama izni yok", Toast.LENGTH_SHORT).show();
    }

    public void listele(){
        List<String> personList = new ArrayList<String>();
        personList = databaseHelper.ListPerson();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, personList);
        lv_person.setAdapter(adapter);
    }
}



