package com.example.miguel.eva1_8_frag_weather.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.miguel.eva1_8_frag_weather.Fragments.DetailsFragment;
import com.example.miguel.eva1_8_frag_weather.Fragments.ItemFragment;
import com.example.miguel.eva1_8_frag_weather.Models.Clima;
import com.example.miguel.eva1_8_frag_weather.R;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private ItemFragment itemFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private DetailsFragment detailsFragment;

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

    @Override
    public void onListFragmentInteraction(Clima item) {
        detailsFragment = new DetailsFragment();
        detailsFragment.onMainToFrag(item.getDesc_clima());
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);
        fragmentTransaction.add(R.id.frameLayout, detailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
