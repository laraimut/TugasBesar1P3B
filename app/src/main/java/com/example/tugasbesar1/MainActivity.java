package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    protected AddFragment addFragment;
    protected MainFragment mainFragment;
    protected FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainFragment=MainFragment.newInstance("this is main frag");
        this.addFragment=AddFragment.newInstance("this id add frag");
        this.fragmentManager=this.getSupportFragmentManager();

        this.changePage(1);
    }
    public void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page == 1){
            if(this.mainFragment.isAdded()){
                ft.show(this.mainFragment);
            }
            else{
                ft.add(R.id.fragment_container , this.mainFragment);
            }
            if(this.addFragment.isAdded()){
                ft.hide(this.addFragment);
            }
        }
        else if(page ==2){
            if(this.mainFragment.isAdded()){
                ft.hide(this.mainFragment);
            }
            if(this.addFragment.isAdded()){
                ft.show(this.addFragment);
            }
            else{
                ft.add(R.id.fragment_container , this.addFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void changeMessage(String message) {
        this.mainFragment.setText(message);

    }
}
