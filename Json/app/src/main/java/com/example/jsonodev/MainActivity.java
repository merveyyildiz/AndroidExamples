package com.example.jsonodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp_hocalar;
    String url = "http://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/school.json";
    ListView lv_dersler;
    ArrayList<String> hocalar = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_hocalar = findViewById(R.id.sp_hocalar);
        lv_dersler=findViewById(R.id.lv_dersler);
        lv_dersler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                RequestQueue queue3=Volley.newRequestQueue(MainActivity.this);
                StringRequest request3=new StringRequest(Request.Method.GET,url,new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obje = new JSONObject(response);
                            JSONArray array = obje.getJSONArray("Dersler");
                            String secilenDersAdi=lv_dersler.getItemAtPosition(position).toString();
                            for(int j=0;j<array.length();j++){
                                JSONObject ders=array.getJSONObject(j);
                                String ad=ders.getString("Adi");
                                if(secilenDersAdi.equals(ad)){
                                    String kredi=ders.getString("Kredisi");
                                    String kodu=ders.getString("Kodu");
                                    Toast.makeText(MainActivity.this, ad+" "+kodu+" "+kredi, Toast.LENGTH_SHORT).show();
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue3.add(request3);
            }
        });
        final RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonobject = new JSONObject(response);
                    JSONArray jsonarray = jsonobject.getJSONArray("OgretimElemanlari");
                    int uzunluk = jsonarray.length();
                    for (int i = 0; i < uzunluk; i++) {
                        JSONObject eleman = jsonarray.getJSONObject(i);
                        String hoca = eleman.getString("adi");
                        hocalar.add(hoca);
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, hocalar);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sp_hocalar.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        sp_hocalar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       final int position, long id) {
                RequestQueue queue1 = Volley.newRequestQueue(MainActivity.this);
                StringRequest request1 = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonobject1 = new JSONObject(response);
                            JSONArray jsonarray2 = jsonobject1.getJSONArray("Dersler");
                            ArrayList<String> dersler = new ArrayList<>();
                            int ders_uzunluk = jsonarray2.length();
                            for (int k = 0; k < ders_uzunluk; k++) {
                                JSONObject ders = jsonarray2.getJSONObject(k);
                                String ogretmenSicil = ders.getString("OgretmenSicil");
                                if (ogretmenSicil == String.valueOf(position+1)) {
                                    String adi = ders.getString("Adi");
                                    dersler.add(adi);
                                }
                            }
                            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dersler);
                            lv_dersler.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue1.add(request1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}}