package com.deneme.mail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "hatali_vardiya_gecmisi")
public class HataliVardiyaGecmisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vardiya_gecmisi_id")
    private VardiyaGecmisi vardiyaGecmisi;

    @Column(name = "vardiya_baslangic_tarihi", nullable = false)
    private LocalDateTime vardiyaBaslangicTarihi;

    @Column(name = "vardiya_bitis_tarihi", nullable = false)
    private LocalDateTime vardiyaBitisTarihi;

    public HataliVardiyaGecmisi() {
    }

    public HataliVardiyaGecmisi(Long id, VardiyaGecmisi vardiyaGecmisi, LocalDateTime vardiyaBaslangicTarihi, LocalDateTime vardiyaBitisTarihi) {
        this.id = id;
        this.vardiyaGecmisi = vardiyaGecmisi;
        this.vardiyaBaslangicTarihi = vardiyaBaslangicTarihi;
        this.vardiyaBitisTarihi = vardiyaBitisTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VardiyaGecmisi getVardiyaGecmisi() {
        return vardiyaGecmisi;
    }

    public void setVardiyaGecmisi(VardiyaGecmisi vardiyaGecmisi) {
        this.vardiyaGecmisi = vardiyaGecmisi;
    }

    public LocalDateTime getVardiyaBaslangicTarihi() {
        return vardiyaBaslangicTarihi;
    }

    public void setVardiyaBaslangicTarihi(LocalDateTime vardiyaBaslangicTarihi) {
        this.vardiyaBaslangicTarihi = vardiyaBaslangicTarihi;
    }

    public LocalDateTime getVardiyaBitisTarihi() {
        return vardiyaBitisTarihi;
    }

    public void setVardiyaBitisTarihi(LocalDateTime vardiyaBitisTarihi) {
        this.vardiyaBitisTarihi = vardiyaBitisTarihi;
    }
}

