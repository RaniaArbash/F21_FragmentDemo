package com.example.f21_fragmentdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class FragmentDialog extends DialogFragment {

    public interface DialogClickListener{
         void dialogListnerWithCity(String city);
         void dialogListnerWithCancel();
    }

    public DialogClickListener listener;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;

    public FragmentDialog() {
        // Required empty public constructor
    }

    public static FragmentDialog newInstance(String param1) {
        FragmentDialog fragment = new FragmentDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
       // args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        return new AlertDialog.Builder(requireContext())
//                .setMessage("Hello this is the defult dialgo")
//                .setPositiveButton("OK", (dialog, which) -> {} ).setNegativeButton("Cancel",null)
//                .create();
//    }
////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        TextView textView = v.findViewById(R.id.text_in_dialog);
        textView.setText(mParam1);

        EditText citytext = v.findViewById(R.id.city_text);

        Button yes = v.findViewById(R.id.yesid);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!citytext.getText().toString().isEmpty())
                listener.dialogListnerWithCity(citytext.getText().toString());
                dismiss();
            }
        });
        Button no = v.findViewById(R.id.noid);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.dialogListnerWithCancel();
                dismiss();
            }
        });



        return v;



    }
}