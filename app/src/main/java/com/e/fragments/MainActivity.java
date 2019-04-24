package com.e.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Fragments.FirstFragment;
import Fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFragment;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment= findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        FragmentManager firstFragment =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = firstFragment.beginTransaction();

        if (status)
        {
            FirstFragment firstFragment1 = new FirstFragment();
            fragmentTransaction.add(R.id.fragmentContainer,firstFragment1);
            fragmentTransaction.commit();
            btnFragment.setText("Load Second Fragment");
            status=false;

        }
        else
            {
                SecondFragment secondFragment = new SecondFragment();
                fragmentTransaction.replace(R.id.fragmentContainer,secondFragment);
                fragmentTransaction.commit();
                btnFragment.setText("Load First Fragment");
                status=true;
        }

    }
}
