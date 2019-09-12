package com.example.tugasbesar1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentListener {

//    protected com.example.calculator.AddFragment addFragment;
//    protected com.example.calculator.MainFragment mainFragment;
//    protected FragmentManager fragmentManager;
//    private ListView exampleList;
//    private AdapterList exampleAdapter;
    protected FragmentManager fragmentManager;
    public MainFragment mainFragment;
    protected AddFragment addFragment;
    protected ResultFragment resultFragment;
    private Spinner operatorcuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainFragment=MainFragment.newInstance("");
        this.addFragment=AddFragment.newInstance("");
        this.resultFragment=ResultFragment.newInstance("");
        this.fragmentManager=this.getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction() ;
  ft.add(R.id.fragment_container , this.mainFragment);
  ft.add(R.id.fragment_container,this.addFragment);
  ft.add(R.id.fragment_container,this.resultFragment);
  ft.hide(this.addFragment);
  ft.hide(this.resultFragment);
  ft.commit();
//        tambah(new Angka("asd" , "asd"));


        //this.mainFragment.test();
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
            this.resultFragment=ResultFragment.newInstance("");
            this.resultFragment.show(this.getSupportFragmentManager(),"dialog");
        }else if(page==4){
            this.resultFragment.dismiss();
        }
        ft.commit() ;
    }

    @Override
    public void changeMessage(String Message) {

    }

    @Override
    public void tambah (Angka angka) {
        this.mainFragment.tambahh(angka);
    }

//
//        public void changePage(int page){
//        FragmentTransaction ft = this.fragmentManager.beginTransaction();
//        if(page == 1){
//            if(this.mainFragment.isAdded()){
//                ft.show(this.mainFragment);
//            }
//            else{
//                ft.add(R.id.fragment_container , this.mainFragment);
//            }
//            if(this.addFragment.isAdded()){
//                ft.hide(this.addFragment);
//            }
//        }
//        else if(page ==2){
//            if(this.mainFragment.isAdded()){
//                ft.hide(this.mainFragment);
//            }
//            if(this.addFragment.isAdded()){
//                ft.show(this.addFragment);
//            }
//            else{
//                ft.add(R.id.fragment_container , this.addFragment);
//            }
//        }
//        ft.commit();
//    }

//    @Override
//    public void changeMessage(String message) {
//        this.mainFragment.setText(message);
//
//    }
}
