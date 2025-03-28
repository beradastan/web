package com.example.sunum.Eslesme;

import com.example.sunum.DataTransferObject.OgrenciDTO;
import com.example.sunum.Veri.Ogrenci;

public class Esleme {

    public static OgrenciDTO ogrenciDTOEsle(Ogrenci ogrenci){
        OgrenciDTO ogrenciDTO = new OgrenciDTO(
                ogrenci.getNum(),
                ogrenci.getAd(),
                ogrenci.getSoyad(),
                ogrenci.getYas()
        );
        return ogrenciDTO;
    }

    public static Ogrenci ogrenciEsle(OgrenciDTO ogrenciDTO){
        Ogrenci ogr1 = new Ogrenci(
                ogrenciDTO.getNum(),
                ogrenciDTO.getAd(),
                ogrenciDTO.getSoyad(),
                ogrenciDTO.getYas()
        );
        return ogr1;
    }
}
//Ogrenci ve Ogrenci DTO ile Browser arasındaki geçişleri yapması için.