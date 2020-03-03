package com.example.findnoy.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.findnoy.R;

public class DashboardFragment extends Fragment {

    ImageView missing, wanted, car, map;
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        missing = rootView.findViewById(R.id.cardMissing);
        wanted = rootView.findViewById(R.id.cardWanted);
        car = rootView.findViewById(R.id.cardCar);
        map = rootView.findViewById(R.id.cardMap);

        missing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MissingPersonFragment fragMissing = new MissingPersonFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragMissing);
                fragmentTransaction.commit();
            }
        });

        wanted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WantedPersonFragment fragWanted = new WantedPersonFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragWanted);
                fragmentTransaction.commit();
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarnappedFragment fragCarnapped = new CarnappedFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragCarnapped);
                fragmentTransaction.commit();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rootView;
    }
}
