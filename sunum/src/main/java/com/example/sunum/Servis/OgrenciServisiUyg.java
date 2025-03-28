package com.example.sunum.Servis;

import com.example.sunum.DataTransferObject.OgrenciDTO;
import com.example.sunum.Eslesme.Esleme;
import com.example.sunum.Repo.OgrenciRepo;
import com.example.sunum.Veri.Ogrenci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OgrenciServisiUyg implements OgrenciServisi{

    private OgrenciRepo ogrenciRepo;

    @Autowired
    public OgrenciServisiUyg(OgrenciRepo ogrenciRepo){
        this.ogrenciRepo = ogrenciRepo;
    }


    @Override
    public void yeniOgrKaydet(OgrenciDTO ogrenciDTO){
        Ogrenci ogrenci = Esleme.ogrenciEsle(ogrenciDTO);
        ogrenciRepo.save(ogrenci);
    }
    @Override
    public List<OgrenciDTO> getButunOgr(){
        List<Ogrenci> ogrenciListesi = ogrenciRepo.findAll();
        //burada öğrenciyi öğrencidto ya çevirlim
        List<OgrenciDTO> ogrenciDTOListesi = ogrenciListesi.stream().map((ogrenci) -> Esleme.ogrenciDTOEsle(ogrenci)).collect(Collectors.toList());
    return ogrenciDTOListesi;
    }

    @Override
    public void guncelleTamamla(OgrenciDTO ogrenciDTO){
        ogrenciRepo.save(Esleme.ogrenciEsle(ogrenciDTO));
    }

    @Override
    public OgrenciDTO getOgrenciId(Long id){
        Ogrenci ogrenci=ogrenciRepo.findById(id).get();
        OgrenciDTO ogrenciDTO=Esleme.ogrenciDTOEsle(ogrenci);
        return ogrenciDTO;
    }

    @Override
    public void sil(Long num){
        ogrenciRepo.deleteById(num);
    }
}
