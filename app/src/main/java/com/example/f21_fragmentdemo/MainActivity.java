package com.example.f21_fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentDialog.DialogClickListener {
    FragmentManager fm = getSupportFragmentManager();
    TextView cityText;

    static public int numOfClicked = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityText = findViewById(R.id.city);
        ((myApp)getApplication()).globalValue = "Hello";
    }

    public void swich_clicked(View view) {

        FragmentTwo f2 = new FragmentTwo();
        fm.beginTransaction().replace(R.id.container1,f2).commit();

            }

    public void second_swich_clicked(View view) {

        FragmentOne f1 = new FragmentOne();
        fm.beginTransaction().replace(R.id.container1,f1).commit();

    }

    public void add_remove_fragment(View view) {
        FragmentThree f3 = (FragmentThree) fm.findFragmentById(R.id.add_remove_area);
        if (f3 == null){
            // add f3
            f3 = new FragmentThree();
            fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fm.beginTransaction().add(R.id.add_remove_area,f3).commit();

        }
        else {
            // remove it
            fm.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fm.beginTransaction().remove(f3).commit();
        }
    }

    public void open_dialog(View view) {
      //  numOfClicked++;
        FragmentDialog msg_fragment = FragmentDialog.newInstance("Please Enter your city ");
        msg_fragment.listener = this;
     //  FragmentDialog msg_fragment = new FragmentDialog();
        msg_fragment.show(fm.beginTransaction(),"1");

    }

    @Override
    public void dialogListnerWithCity(String city) {
        cityText.setText("City From the dialog is " + city);
    }

    @Override
    public void dialogListnerWithCancel() {
        cityText.setText("No city entered!!!!");

    }
}