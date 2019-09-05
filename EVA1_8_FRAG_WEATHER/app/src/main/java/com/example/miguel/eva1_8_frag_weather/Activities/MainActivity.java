package com.example.miguel.eva1_8_frag_weather.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.miguel.eva1_8_frag_weather.Fragments.ItemFragment;
import com.example.miguel.eva1_8_frag_weather.R;

public class MainActivity extends AppCompatActivity {

    private ItemFragment itemFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        itemFragment = new ItemFragment();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.frameLayout, itemFragment);
        fragmentTransaction.commit();
    }

}
