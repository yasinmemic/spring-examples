package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi = new Kisi();
        kisi.setAd("Yasin");
        kisi.setSoyad("Memic");
        kisi.setAdres("Cekmekoy");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisiRepository.save(kisi);
    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiList = kisiRepository.getAllByAdLikeOrSoyadLike(search,search);
        if(kisiList.size() != 0)
        return ResponseEntity.ok(kisiList);
        else
            return null;
    }
}
