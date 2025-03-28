package com.example.sunum.Controller;

import com.example.sunum.DataTransferObject.OgrenciDTO;
import com.example.sunum.Servis.OgrenciServisi;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class OgrenciKontroller {
    private OgrenciServisi ogrenciServisi;
    public OgrenciKontroller(OgrenciServisi ogrenciServisi){
        this.ogrenciServisi=ogrenciServisi;
    }

    @PostMapping("/ogrenciler")
    public String ogrenciyiKaydet(@Valid @ModelAttribute("ogrenci") OgrenciDTO ogrenciDTO , BindingResult result , Model model){

        if(result.hasErrors()){
            model.addAttribute("ogrenci" , ogrenciDTO);
            return "/yeniOgrSayfasi";
        }
        ogrenciServisi.yeniOgrKaydet(ogrenciDTO);
        return "redirect:/obsGetirHepsi";
    }


    @GetMapping("/yeniogr")
    public String yeniOgrenci(Model model){
        OgrenciDTO ogrenciDTO = new OgrenciDTO();
        model.addAttribute("ogrenci",ogrenciDTO);
        return "yeniOgrSayfasi";
    }

    @GetMapping("/obsGetirHepsi")
    public String getirButunOgrenciler(Model model){
        List<OgrenciDTO> ogrencilerGetir = ogrenciServisi.getButunOgr();
        model.addAttribute("ogrenciler",ogrencilerGetir);
        return  "getirOBSOgrHepsi";
    }

    @PostMapping("/ogrenciler/{id}")
    public String ogrenciGuncelleTamamla(@PathVariable("id") Long num, @ModelAttribute("ogrenci") OgrenciDTO ogrenciDTO ,

                                         BindingResult result , Model model){
        if(result.hasErrors()){
            model.addAttribute("ogrenci",ogrenciDTO);
            return "guncelleOgrSayfasi";
        }
        ogrenciDTO.setNum(num);
        ogrenciServisi.guncelleTamamla(ogrenciDTO);
        return "redirect:/obsGetirHepsi";
    }

    @GetMapping("/ogrenciler/{id}/guncelle")
    public String ogrenciGuncelle(@PathVariable("id") Long num , Model model){
        OgrenciDTO ogrenci=ogrenciServisi.getOgrenciId(num);
        model.addAttribute("ogrenci" , ogrenci);
        return "guncelleOgrSayfasi";
    }

    @GetMapping("/ogrenciler/{id}/goruntule")
    public String ogrenciGoruntule(@PathVariable("id") Long num , Model model){
        OgrenciDTO ogrenci = ogrenciServisi.getOgrenciId(num);
        model.addAttribute("ogrenci" , ogrenci);
        return "goruntuleOgrSayfasi";
    }

    @GetMapping("/ogrenciler/{id}/sil")
    public String ogrenciSil(@PathVariable("id") Long num , Model model){
        ogrenciServisi.sil(num);
        return "redirect:/obsGetirHepsi";
    }



}
