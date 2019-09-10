package com.example.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.tugasbesar1.R;

public class AddFragment extends Fragment implements View.OnClickListener {

    protected Button btnSubmit;
    protected EditText inputOperand;
    protected com.example.calculator.FragmentListener listener;

    public static AddFragment newInstance(String value){
        AddFragment addFragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString("title" , value);
        addFragment.setArguments(args);
        return  addFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_add,container,false);
        this.btnSubmit= view.findViewById(R.id.btn_Submit);
        this.inputOperand= view.findViewById((R.id.operand));
        this.btnSubmit.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==this.btnSubmit.getId())
        {
            String strOperand= this.inputOperand.getText().toString();
            this.listener.changePage(1);
            this.listener.changeMessage(strOperand);
            int intOperand=Integer.parseInt(strOperand);
        }
    }
}
