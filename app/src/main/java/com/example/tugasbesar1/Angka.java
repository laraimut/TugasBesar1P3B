package com.example.tugasbesar1;

class Angka {

    private String tanda;
    private String angka;

    public Angka (String tanda, String angka){
        this.angka = angka;
        this.tanda = tanda;
    }

    public void setAngka (String angka){
        this.angka = angka;
    }
    public void setTanda (String tanda){
        this.tanda = tanda;

    }

    public String getAngka (){
        return this.angka;
    }
    public  String getTanda(){
        return this.tanda;
    }

}