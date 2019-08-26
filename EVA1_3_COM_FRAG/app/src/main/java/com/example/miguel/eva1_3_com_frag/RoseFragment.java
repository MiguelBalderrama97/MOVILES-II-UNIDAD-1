package com.example.miguel.eva1_3_com_frag;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoseFragment extends Fragment implements FragmentCom{

    private View view;
    private MainActivity mainActivity;

    public RoseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_rose, container, false);

        Button btnSend = view.findViewById(R.id.btnSendInfo);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onFromFragToMain("GREEN","Funciona");
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onFromMainToFrag(String msg) {

    }
}
