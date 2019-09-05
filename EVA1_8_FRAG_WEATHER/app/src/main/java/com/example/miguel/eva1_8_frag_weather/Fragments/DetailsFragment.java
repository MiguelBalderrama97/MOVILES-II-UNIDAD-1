package com.example.miguel.eva1_8_frag_weather.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.miguel.eva1_8_frag_weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private View view;

    private TextView txtDetails;

    private String msg;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details, container, false);

        txtDetails = view.findViewById(R.id.txtDetails);

        txtDetails.setText(this.msg);
        return view;
    }

    public void onMainToFrag(String msg){
        this.msg = msg;
    }

}
