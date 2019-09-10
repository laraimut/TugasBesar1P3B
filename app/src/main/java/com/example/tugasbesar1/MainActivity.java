package com.example.tugasbesar1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

//    protected com.example.calculator.AddFragment addFragment;
//    protected com.example.calculator.MainFragment mainFragment;
//    protected FragmentManager fragmentManager;
    private ListView exampleList;
    private Adapter exampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.mainFragment= com.example.calculator.MainFragment.newInstance("this is main frag");
//        this.addFragment= com.example.calculator.AddFragment.newInstance("this id add frag");
//        this.fragmentManager=this.getSupportFragmentManager();

        this.exampleList = this.findViewById(R.id.list_tv);
        this.exampleAdapter = new Adapter(this);
        this.exampleAdapter.add("test");
        this.exampleList.setAdapter(exampleAdapter);


//        this.changePage(1);
    }
//    public void changePage(int page){
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
