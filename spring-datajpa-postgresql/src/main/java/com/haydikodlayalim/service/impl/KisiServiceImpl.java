package com.haydikodlayalim.service.impl;

import com.haydikodlayalim.dto.KisiDto;
import com.haydikodlayalim.entity.Adres;
import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repo.AdresRepository;
import com.haydikodlayalim.repo.KisiRepository;
import com.haydikodlayalim.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;
    @Override
    public KisiDto save(KisiDto kisiDto) {
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());

        List<Adres> adresList = new ArrayList<>();
        kisiDto.getAdresList().forEach( item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.EV_ADRESI);
            adres.setAktif(true);
            adres.setKisi(kisi);
            adresList.add(adres);
        });
        kisiRepository.save(kisi);
        adresRepository.saveAll(adresList);
        kisiDto.setId(kisi.getId());
        return kisiDto;
    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiList = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiList.forEach(item -> {
            KisiDto dto = new KisiDto();
            dto.setId(item.getId());
            dto.setAdi(item.getAdi());
            dto.setSoyadi(item.getSoyadi());
            dto.setAdresList(item.getAdresList().stream().map(Adres::getAdres)
            .collect(Collectors.toList()));
            kisiDtos.add(dto);
        });

        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
