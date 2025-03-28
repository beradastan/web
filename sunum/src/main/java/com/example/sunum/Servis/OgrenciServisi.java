package com.example.sunum.Servis;

import com.example.sunum.DataTransferObject.OgrenciDTO;

import java.util.List;

public interface OgrenciServisi {
    void yeniOgrKaydet(OgrenciDTO ogrenciDTO);
    List<OgrenciDTO> getButunOgr();

    OgrenciDTO getOgrenciId(Long id);

    void guncelleTamamla(OgrenciDTO ogrenciDTO);
    void sil(Long num);

}
