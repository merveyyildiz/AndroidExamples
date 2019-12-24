package com.example.fragmentodev2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;


public class Detail extends Fragment {
    String name,versiyon,api;
    TextView tv_name,tv_version,tv_api,androdi,vers,ap;


    public Detail() {
        // Required empty public constructor
    }

    public static Detail newInstance(String name,String versiyon,String api) {
        Detail fragment = new Detail();
        Bundle args = new Bundle();
        args.putString("name",name);
        args.putString("versiyon",versiyon);
        args.putString("api",api);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
           name=getArguments().getString("name");
           versiyon=getArguments().getString("versiyon");
           api=getArguments().getString("api");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_detail, container, false);
        androdi=view.findViewById(R.id.android);
        vers=view.findViewById(R.id.vers);
        ap=view.findViewById(R.id.api);
        tv_name=view.findViewById(R.id.tv_name);
        tv_version=view.findViewById(R.id.tv_versiyon);
        tv_api=view.findViewById(R.id.tv_api);
        tv_name.setText(name);
        tv_version.setText(versiyon);
        tv_api.setText(api);
        System.out.println(name);
        return view;
    }

}
