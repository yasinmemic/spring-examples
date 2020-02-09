package com.haydikodlayalim.repo;

import com.haydikodlayalim.entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisiRepository extends JpaRepository<Kisi,Long> {
}
