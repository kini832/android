package com.example.findnoy.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.findnoy.Activity.MissingPersonInformation;
import com.example.findnoy.Lists.MissingList;
import com.example.findnoy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterMissing extends BaseAdapter implements View.OnClickListener {

    Context context;
    ArrayList<MissingList> list;
    LayoutInflater inflater;


    public AdapterMissing(Context context, ArrayList<MissingList> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListHandler handler = null;

        if(convertView==null){
            convertView = inflater.inflate(R.layout.missinglistlayout, null);
            handler = new ListHandler();
            handler.profile = (ImageView) convertView.findViewById(R.id.missingProfile);
            handler.name = (TextView) convertView.findViewById(R.id.missingName);
            handler.place = (TextView) convertView.findViewById(R.id.missingPlace);
            handler.date = (TextView) convertView.findViewById(R.id.missingDate);
            handler.status = (TextView) convertView.findViewById(R.id.status);
            handler.view = (TextView) convertView.findViewById(R.id.view);

            convertView.setTag(handler);
        }else handler = (ListHandler) convertView.getTag();
        handler.name.setText(list.get(position).getName());
        handler.place.setText(list.get(position).getLastseen());
        handler.date.setText(list.get(position).getLastseendate());
        handler.status.setText(list.get(position).getStatus());

       // if(list.get(position).getProfile().equals("")){
            handler.profile.setImageResource(R.drawable.missingpersonblue);
      //  }else {
      //      Picasso.with(context).load(list.get(position).getProfile()).into(handler.profile);
       // }

        handler.view.setOnClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        Intent missngInfo = new Intent(context, MissingPersonInformation.class);
        context.startActivity(missngInfo);
    }

    static class ListHandler{

        ImageView profile;
        TextView name, place, date,status,view;

    }

}
