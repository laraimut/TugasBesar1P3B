package com.example.tugasbesar1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tugasbesar1.R;


public class ResultFragment extends androidx.fragment.app.DialogFragment {
    private TextView result;

    public static ResultFragment newInstance(String text){
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putString("result" , text);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.resultfragment,container,false);
        this.result = view.findViewById(R.id.tvResult);
        this.result.setText(this.getArguments().getString("result" ,""));
        return view;
    }


}
