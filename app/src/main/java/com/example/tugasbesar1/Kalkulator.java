package com.example.tugasbesar1;

public class Kalkulator {

    public int hitung(AdapterList al){
        int res=0;
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

    public int hitung2(AdapterList al,int index){
        int res=0;
        for(int i=0; i<index;i++){
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