package com.example.tugasbesar1;

import java.text.DecimalFormat;

public class Kalkulator {

    public double hitung(AdapterList al){
        double res=0;
        for(int i=0; i<al.getCount();i++){
            Angka a= (Angka) al.getItem(i);
            if(a.getTanda().equals("+")){
                res+= Integer.parseInt(a.getAngka().trim());
            }else if(a.getTanda().equals("-")){
                res-= Integer.parseInt(a.getAngka().trim());
            }else if(a.getTanda().equals("/")){
                res/= Integer.parseInt(a.getAngka().trim());
            }else if(a.getTanda().equals("*")){
                res*= Integer.parseInt(a.getAngka().trim());
            }
        }


        return res;
    }
}