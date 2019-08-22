package com.example.miguel.eva1_3_com_frag;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RoseFragment roseFragment;
    private GreenFragment greenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        if(fragment.getClass() == RoseFragment.class){
            roseFragment = (RoseFragment) fragment;
        }else if(fragment.getClass() == GreenFragment.class){
            greenFragment = (GreenFragment) fragment;
        }
    }
}
