package com.example.tugasbesar1;

import android.app.Activity;
import android.net.wifi.aware.PublishConfig;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private ArrayList<String> arrayList;
    private Activity activity;

    public Adapter(Activity activity){
        this.activity = activity;
        this.arrayList = new ArrayList<>();
    }

    public void add(String s){
        this.arrayList.add(s);
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
        viewHolder.updateView(this.getItem(i) + "");
        return  view;

    }

    private class ViewHolder{
//        insser all your view element here
        protected TextView textView;
        public ViewHolder(View view){
            this.textView = view.findViewById(R.id.list_tv);
        }

//        update all your list here
        public void updateView(String s){
            this.textView.setText(s);
        }

    }
}
