package com.example.simple.myrememberdfirebase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Bundle bundle = getArguments();
        assert bundle != null;
        String month = bundle.getString("month");

        TextView txt_month = view.findViewById(R.id.txt_month);
        txt_month.setText(month);
        return view;
    }

}
