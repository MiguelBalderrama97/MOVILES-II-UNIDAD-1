package com.example.miguel.eva1_4_frag_din;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnFirst, btnSecond;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        btnFirst = findViewById(R.id.btnFisrt);
        btnSecond = findViewById(R.id.btnSecond);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = fragmentManager.beginTransaction();
                firstFragment = new FirstFragment();
//                fragmentTransaction.replace(R.id.frameFragmentos, firstFragment);
//                fragmentTransaction.commit();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.add(R.id.frameFragmentos,firstFragment,"FIRST");
                fragmentTransaction.commit();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = fragmentManager.beginTransaction();
                secondFragment = new SecondFragment();
//                fragmentTransaction.replace(R.id.frameFragmentos, secondFragment);
//                fragmentTransaction.commit();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.add(R.id.frameFragmentos,secondFragment,"SECOND");
                fragmentTransaction.commit();
            }
        });
    }
}
