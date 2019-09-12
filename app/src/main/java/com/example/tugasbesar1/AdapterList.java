package com.example.tugasbesar1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends BaseAdapter {

    private ArrayList<Angka> arrayList;
    private Activity activity;

    public AdapterList(Activity activity){
        this.activity = activity;
        this.arrayList = new ArrayList<>();
    }

    public void add(Angka a){
        this.arrayList.add(a);
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.arrayList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(this.activity).inflate(R.layout.list , viewGroup , false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Angka a = (Angka) this.getItem(i);
        viewHolder.updateView(a.getAngka() + "",a.getTanda());
        return  view;

    }
    public void clearList()
    {
        this.arrayList.clear();
    }


    private class ViewHolder{
//        insert all your view element here
        protected TextView textViewa;
        protected TextView textViewb;
        public ViewHolder(View view){
            this.textViewa = view.findViewById(R.id.list_tv);
            this.textViewb = view.findViewById(R.id.kode);
        }

//        update all your list here
        public void updateView(String angka, String kode){
            this.textViewa.setText(angka);
            this.textViewb.setText(kode);
        }


    }
}
