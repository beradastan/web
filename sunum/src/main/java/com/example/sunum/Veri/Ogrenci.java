package com.example.sunum.Veri;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity

public class Ogrenci {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private String ad;
    private String soyad;
    private int yas;

    public Ogrenci(){

    }

    public Ogrenci(Long num , String ad , String soyad , int yas){
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
