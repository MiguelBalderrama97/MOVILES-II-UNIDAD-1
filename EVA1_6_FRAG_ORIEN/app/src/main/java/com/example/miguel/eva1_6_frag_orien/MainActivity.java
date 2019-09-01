package com.example.miguel.eva1_6_frag_orien;

import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private GreenFragment greenFragment;
    private RoseFragment roseFragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            greenFragment = new GreenFragment();
            fragmentTransaction.replace(R.id.fragmentGreenPort, greenFragment);
            fragmentTransaction.commit();

        }else{
            greenFragment = new GreenFragment();
            roseFragment = new RoseFragment();
            fragmentTransaction.replace(R.id.fragmentGreenLand, greenFragment);
            fragmentTransaction.replace(R.id.fragmentRoseLand, roseFragment);
            fragmentTransaction.commit();
        }
    }
}
