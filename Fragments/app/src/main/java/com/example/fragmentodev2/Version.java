package com.example.fragmentodev2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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


public class Version extends Fragment {
  public VersionGonder versiyon;
  ListView lv_list;
  ArrayList<String> versiyons;
  ArrayList<String> names;
  ArrayList<String> apiKeys;

  String url="http://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/AndroidVersion.json";
    public Version() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        versiyons=new ArrayList<>();
        names=new ArrayList<>();
        apiKeys=new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_version2, container, false);
        lv_list=view.findViewById(R.id.lv_version);
        RequestQueue queue= Volley.newRequestQueue(getContext());
        StringRequest request=new StringRequest(Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray dizi=new JSONArray(response);
                    int uzunluk=dizi.length();
                    for(int i=0;i<uzunluk;i++){
                        JSONObject obje=dizi.getJSONObject(i);
                        String name=obje.getString("Name");
                        String api=obje.getString("APINo");
                        String vers=obje.getString("Version");
                        names.add(name);
                        apiKeys.add(api);
                        versiyons.add(vers);
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,names);
                    lv_list.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gonder1=names.get(position);
                String gonder2=versiyons.get(position);
                String gonder3=apiKeys.get(position);
                versiyon.idAL(gonder1,gonder2,gonder3);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VersionGonder) {
           versiyon=(VersionGonder)context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface VersionGonder {
       public void idAL(String name,String version,String api);
    }
}
