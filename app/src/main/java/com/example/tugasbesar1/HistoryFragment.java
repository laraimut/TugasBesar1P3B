package com.example.tugasbesar1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class HistoryFragment extends Fragment {
    public FragmentListener listener;
    public Presenter presenter;
    public static HistoryFragment newInstance(String value){
        HistoryFragment historyFragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString("title" , value);
        historyFragment.setArguments(args);
        return  historyFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_history,container,false);

        return view;
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
}
