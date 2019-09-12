package com.example.tugasbesar1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment implements View.OnClickListener {

    protected Button btnSubmit;
    protected EditText inputOperand;
    protected FragmentListener listener;
    protected Presenter pres;
    private String tanda;
    private TextView angkaa;
    private Spinner operatorcuy;


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
        this.angkaa = view.findViewById(R.id.operator);
        this.operatorcuy =view.findViewById(R.id.operators);

        return view;
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==this.btnSubmit.getId())
        {
            this.tanda = this.operatorcuy.getSelectedItem().toString();
            String text = inputOperand.getText().toString();
            Angka angka = new Angka(this.tanda,text);
            this.pres.tambah(angka);

            this.listener.changePage(2);

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener=(FragmentListener) context;
        }
        if(context instanceof Presenter){
            this.pres=(Presenter) context;
        }
    }
}