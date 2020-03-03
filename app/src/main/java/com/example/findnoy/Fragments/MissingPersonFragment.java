package com.example.findnoy.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.example.findnoy.Adapters.AdapterMissing;
import com.example.findnoy.Lists.MissingList;
import com.example.findnoy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MissingPersonFragment extends Fragment {

    SwipeMenuListView listView;
    SwipeRefreshLayout pullToRefresh;
    LinearLayout layout;
    private View rootView;
    ArrayList<MissingList> list = new ArrayList<MissingList>();
    AdapterMissing adapter;
    private static String URL_MISSING = "http://192.168.43.23/FindNoy/missingperson.php";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_missing_person, container, false);
       // return inflater.inflate(R.layout.fragment_missing_person, container, false);

        pullToRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.pullToRefresh);
        listView = rootView.findViewById(R.id.listview);
        adapter = new AdapterMissing(getActivity(),list);
        listView.setAdapter(adapter);

        loadMissingPerson();

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            int Refreshcounter = 1;

            @Override
            public void onRefresh() {
                Refreshcounter = Refreshcounter + 1;
                adapter.notifyDataSetChanged();
                pullToRefresh.setRefreshing(false);
            }
        });

        return rootView;
    }

    // ---------- RETRIEVE DATA FROM DATABASE ---------------//
    private void loadMissingPerson(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_MISSING,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray missing = new JSONArray(response);

                    for(int i = 0; i <= missing.length(); i++){
                        JSONObject jsonObject = missing.getJSONObject(i);

                     //   String profile = jsonObject.getString("profile");
                        String name = jsonObject.getString("name");
                        String lastseen = jsonObject.getString("lastseen");
                        String lastseendate = jsonObject.getString("lastseendate");
                        String status = jsonObject.getString("status");


                        MissingList missingList = new MissingList(name,lastseen,lastseendate,status);
                        list.add(missingList);
                        adapter.notifyDataSetChanged();
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }


}
