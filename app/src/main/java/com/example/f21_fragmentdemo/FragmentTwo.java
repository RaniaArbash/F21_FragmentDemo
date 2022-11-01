package com.example.f21_fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class FragmentTwo extends Fragment {

    String valueFromActivity;

    public static FragmentTwo newInstance(String textToUse){
        FragmentTwo newF2Object = new FragmentTwo();
        Bundle b = new Bundle();
        b.putString("VFA", textToUse);
        newF2Object.setArguments(b);
        return newF2Object;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            valueFromActivity = getArguments().getString("VFA");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        TextView tv = v.findViewById(R.id.tif2);
        tv.setText(valueFromActivity);
        return v;
    }
}