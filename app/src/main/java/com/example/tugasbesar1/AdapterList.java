package com.example.tugasbesar1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends BaseAdapter {

    public ArrayList<Angka> arrayList;
    private Activity activity;
    protected Presenter fl;

    public AdapterList(Activity activity,Presenter fl){
        this.activity = activity;
        this.arrayList = new ArrayList<>();
        this.fl=fl;
    }

    public void add(Angka a){
        this.arrayList.add(a);
        this.notifyDataSetChanged();
    }

    public void delete(int i){
        this.arrayList.remove(i);
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

    public ArrayList getall(){
        return this.arrayList;
    }
    public void setArrayList(ArrayList arr){
        this.arrayList = arr;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    public void delete(){

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Kalkulator kal;
        if(view == null){
            view = LayoutInflater.from(this.activity).inflate(R.layout.list , viewGroup , false);
            viewHolder = new ViewHolder(view,i,fl);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Angka a = (Angka) this.getItem(i);
        viewHolder.setIndex(i);
        kal=new Kalkulator();
        int res=kal.hitung2(this,i);
        viewHolder.updateView(a.getAngka() + "",a.getTanda(),res);
        return  view;

    }
    public void clearList()
    {
        this.arrayList.clear();
    }


    private class ViewHolder implements View.OnClickListener {
        //        insert all your view element here
        protected TextView textViewa,res;
        protected TextView textViewb;
        protected ImageView sampah;
        protected int index;
        protected Presenter pres;
        public ViewHolder(View view,int i,Presenter fl){
            this.textViewa = view.findViewById(R.id.list_tv);
            this.textViewb = view.findViewById(R.id.kode);
            this.sampah=view.findViewById(R.id.sampah);
            this.index=i;
            this.pres=fl;
            this.sampah.setOnClickListener(this);
            this.res=view.findViewById(R.id.list_res);
        }

        //        update all your list here
        public void updateView(String angka, String kode,int res){
            this.textViewa.setText(angka);
            this.textViewb.setText(kode);
            this.res.setText(res+"");
        }

        public void setIndex(int i){this.index=i;}


        @Override
        public void onClick(View view) {
            if(view.getId()==this.sampah.getId()){
                this.pres.delete(this.index);

            }
        }
    }
}