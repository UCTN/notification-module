package com.deneme.mail.repository;

import com.deneme.mail.entity.HataliVardiyaGecmisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HataliVardiyaGecmisiRepository extends JpaRepository<HataliVardiyaGecmisi, Long> {

    @Query(value = "SELECT * FROM hatali_vardiya_gecmisi WHERE DATE(vardiya_baslangic_tarihi) = CURRENT_DATE", nativeQuery = true)
    List<HataliVardiyaGecmisi> findByVardiyaBaslangicTarihiToday();

}
