package com.example.tugasbesar1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;



public class MainFragment extends Fragment implements View.OnClickListener {
    protected Button btnAdd, btnRes, btnClear, btnSave ,btnsubmit;

    public FragmentListener listener;

    protected TextView output;

    public AdapterList adapterList;
    public ListView exampleList;
    public AdapterList exampleAdapter;



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
        this.btnRes.setOnClickListener(this);
        this.exampleAdapter = new AdapterList(this.getActivity());
        this.exampleList = view.findViewById(R.id.listview);
        this.exampleList.setAdapter(this.exampleAdapter);
//        this.tambah(new Angka("-","00-"));
        return view;
    }
    @Override
    public void onClick(View view) {
       if(view.getId()==this.btnAdd.getId()) {
//           Log.d("debug", "onClick: ");


           this.listener.changePage(2);
       }

       if(view.getId()==this.btnRes.getId())
       {
           Log.d("debug", "onClick: CLEAR");
           this.listener.changePage(3);
       }
        if(view.getId()==this.btnClear.getId())
        {
            this.adapterList.clearList();
        }



    }

  public void tambahh (Angka angka){
      this.exampleAdapter.add(angka);
  }

  public void test(){
        this.output.setText("ok");
  }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }
    }

    public void setText(String str)
    {
        this.output.setText(str);
    }

}
