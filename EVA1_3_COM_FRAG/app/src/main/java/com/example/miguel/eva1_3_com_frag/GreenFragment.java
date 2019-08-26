package com.example.miguel.eva1_3_com_frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GreenFragment extends Fragment implements FragmentCom{

    private View view;
    private TextView txtInfo;

    public GreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_green, container, false);
        txtInfo = view.findViewById(R.id.txtSeeInfo);
        return view;
    }

    @Override
    public void onFromMainToFrag(String msg) {
        txtInfo.setText(msg);
    }
}
