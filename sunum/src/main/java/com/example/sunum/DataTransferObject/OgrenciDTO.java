package com.example.sunum.DataTransferObject;

import jakarta.validation.constraints.NotEmpty;

public class OgrenciDTO {
    private Long num;
    @NotEmpty(message = "Ogrenci Adını yaziniz")  //VALİDATİON
    private String ad;
    @NotEmpty(message = "Ogrenci Soyadını Yazınız") //VALİDATİON
    private String soyad;
    private int yas;

    public OgrenciDTO(){

    }
    public OgrenciDTO(Long num , String ad , String soyad , int yas){
        this.ad=ad;
        this.num=num;
        this.soyad=soyad;
        this.yas=yas;
    }

    public void setNum(Long num){
        this.num=num;
    }
    public void setAd(String ad){
        this.ad=ad;
    }
    public void setSoyad(String soyad){
        this.soyad=soyad;
    }
    public void setYas(int yas){
        this.yas=yas;
    }

    public Long getNum(){
        return this.num;
    }
    public String getAd(){
        return this.ad;
    }
    public String getSoyad(){
        return this.soyad;
    }
    public int getYas(){
        return this.yas;
    }
}

//