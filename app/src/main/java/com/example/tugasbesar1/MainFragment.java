package com.example.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tugasbesar1.R;

public class MainFragment extends Fragment implements View.OnClickListener {
    protected Button btnAdd, btnRes, btnClear, btnSave;
    protected com.example.calculator.FragmentListener listener;
    protected TextView output;

    public static MainFragment newInstance(String value){
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("title" , value);
        mainFragment.setArguments(args);
        return  mainFragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_main,container,false);
        this.btnAdd=view.findViewById(R.id.btn_Add);
        this.btnClear=view.findViewById(R.id.btn_Clear);
        this.btnAdd.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
       if(view.getId()==this.btnAdd.getId())
       {
           Log.d("debug", "onClick: ");
           this.listener.changePage(2);
       }
       if(view.getId()==this.btnClear.getId())
       {
           Log.d("debug", "onClick: CLEAR");
       }

    }
    public void setText(String str)
    {
        this.output.setText(str);
    }
}
