package com.haydikodlayalim;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim pet API dokümantasyonum")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1,"Test Pet", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "Yeni pet ekleyen metot",notes = "bu metodu dikkatli kullan (notes)")
    public ResponseEntity<Pet> ekle(@RequestBody @ApiParam(value = "ekleme metoduna gelen parametre") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Tum petleri listeleyen metot")
    public ResponseEntity<List<Pet>> tumunuListele() {
        return ResponseEntity.ok(petList);
    }

}
