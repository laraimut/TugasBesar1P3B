package com.example.tugasbesar1;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentListener,Presenter {


    protected FragmentManager fragmentManager;
    public MainFragment mainFragment;
    protected AddFragment addFragment;
    protected ResultFragment resultFragment;
    private Toolbar toolbar;
    private double res;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainFragment=MainFragment.newInstance("");
        this.addFragment=AddFragment.newInstance("");
        this.resultFragment=ResultFragment.newInstance("");
        this.fragmentManager=this.getSupportFragmentManager();
        this.toolbar = this.findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        DrawerLayout drawer = this.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open , R.string.close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        FragmentTransaction ft = this.fragmentManager.beginTransaction() ;
        ft.add(R.id.fragment_container , this.mainFragment);
        ft.add(R.id.fragment_container,this.addFragment);
        ft.add(R.id.fragment_container,this.resultFragment);
        ft.hide(this.addFragment);
        ft.hide(this.resultFragment);
        ft.commit();

    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction() ;
        if (page==1) {
            ft.show(addFragment);
            ft.hide(mainFragment);
        }else if(page==2){
            ft.hide(addFragment);
            ft.show(mainFragment);
        }else if(page==3){
            this.resultFragment=ResultFragment.newInstance(res+"");
            this.resultFragment.show(this.getSupportFragmentManager(),"dialog");
        }else if(page==4){
            this.resultFragment.dismiss();
        }
        ft.commit() ;
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    public void changeMessage(String Message) {

    }

    @Override
    public void setOutput(double res) {
        this.res=res;
    }

    @Override
    public void tambah (Angka angka) {
        this.mainFragment.tambahh(angka);
    }

    @Override
    public void delete(int i) {
        this.mainFragment.delete(i);
    }




}