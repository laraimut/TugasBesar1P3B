package com.example.tugasbesar1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;


public class ResultFragment extends DialogFragment implements View.OnClickListener {
    private TextView result;
    protected Button btn;
    protected FragmentListener listener;


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
        this.btn=view.findViewById(R.id.button_id);
        this.btn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==this.btn.getId()){
            this.listener.changePage(4);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener=(FragmentListener) context;
        }
    }
}
