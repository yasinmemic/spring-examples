package com.haydikodlayalim.repository;

import com.haydikodlayalim.entity.Kisi;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi,String> {

    List<Kisi> getAllByAdLikeOrSoyadLike(String ad, String soyad);
}
