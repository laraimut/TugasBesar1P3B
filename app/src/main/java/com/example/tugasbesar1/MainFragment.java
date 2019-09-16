package com.example.tugasbesar1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class MainFragment extends Fragment implements View.OnClickListener {
    protected Button btnAdd, btnRes, btnClear, btnSave ,btnsubmit;
    protected Button floatbtn;
    public FragmentListener listener;
    public Presenter presenter;
    protected TextView output;


    public ListView exampleList;
    public AdapterList exampleAdapter;

    public Kalkulator kal;



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
        this.output= view.findViewById(R.id.label);
        this.btnRes=view.findViewById(R.id.btn_Res);
        this.btnSave=view.findViewById(R.id.btn_Save);
        this.floatbtn=view.findViewById(R.id.floatbutton);
        this.floatbtn.setOnClickListener(this);
        this.btnRes.setOnClickListener(this);
        this.btnClear.setOnClickListener(this);
        this.btnSave.setOnClickListener(this);
        this.exampleAdapter = new AdapterList(this.getActivity(),this.presenter);
        this.exampleList = view.findViewById(R.id.listview);
        this.exampleList.setAdapter(this.exampleAdapter);


        this.kal=new Kalkulator();


        this.loadData();

        return view;
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==this.btnAdd.getId()) {


            this.listener.changePage(1);
        }
        if(view.getId()==this.floatbtn.getId()) {


            this.listener.changePage(1);
        }

        if(view.getId()==this.btnRes.getId())
        {
            Log.d("debug", "onClick: CLEAR");

            double res = this.kal.hitung(this.exampleAdapter);
            DecimalFormat df= new DecimalFormat("#.####");
            this.output.setText( df.format(res));
            this.setOutput(res);
            this.listener.changePage(3);

        }
        if(view.getId()==this.btnClear.getId())
        {
            this.exampleAdapter.clearList();
            this.exampleAdapter.notifyDataSetChanged();
        }
        if(view.getId()==this.btnSave.getId()){
            saveData();
        }



    }
    private void saveData(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this.exampleAdapter.getall());
        editor.putString("calculator",json);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("calculator",null);
        Type type = new TypeToken<ArrayList<Angka>>(){}.getType();
        this.exampleAdapter.setArrayList((ArrayList)gson.fromJson(json,type));
         if(this.exampleAdapter.arrayList==null){
             this.exampleAdapter.arrayList = new ArrayList<>();
         }


    }

    public void tambahh (Angka angka){
        this.exampleAdapter.add(angka);
    }

    public void setOutput(double res) {
        this.presenter.setOutput(res);
    }
    public void delete ( int i){
        this.exampleAdapter.delete(i);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }
        if(context instanceof Presenter){
            this.presenter=(Presenter) context;
        }
    }

    public void setText(String str)
    {
        this.output.setText(str);
    }

}