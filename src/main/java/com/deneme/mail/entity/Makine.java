package com.deneme.mail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "makine")
public class Makine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "makine_adi", length = 255, nullable = false)
    private String makineAdi;

    @Column(name = "makine_kodu", length = 255, nullable = false, unique = true)
    private String makineKodu;

    @Column(name = "makine_marka", length = 255, nullable = false)
    private String makineMarka;

    @Column(name = "makine_model", length = 255, nullable = false)
    private String makineModel;

    @Column(name = "makine_kontrolcu", nullable = false)
    private String makineKontrolcu;

    @Column(name = "makine_dosya_yolu", length = 1000)
    private String makineDosyaYolu;

    @Column(name = "makine_kayit_tarihi")
    private LocalDateTime makineKayitTarihi;

    public Makine() {
        this.makineKayitTarihi = LocalDateTime.now();
    }

    public Makine(Long id, String makineAdi, String makineKodu, String makineMarka, String makineModel, String makineKontrolcu, String makineDosyaYolu, LocalDateTime makineKayitTarihi) {
        this.id = id;
        this.makineAdi = makineAdi;
        this.makineKodu = makineKodu;
        this.makineMarka = makineMarka;
        this.makineModel = makineModel;
        this.makineKontrolcu = makineKontrolcu;
        this.makineDosyaYolu = makineDosyaYolu;
        this.makineKayitTarihi = makineKayitTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMakineAdi() {
        return makineAdi;
    }

    public void setMakineAdi(String makineAdi) {
        this.makineAdi = makineAdi;
    }

    public String getMakineKodu() {
        return makineKodu;
    }

    public void setMakineKodu(String makineKodu) {
        this.makineKodu = makineKodu;
    }

    public String getMakineMarka() {
        return makineMarka;
    }

    public void setMakineMarka(String makineMarka) {
        this.makineMarka = makineMarka;
    }

    public String getMakineModel() {
        return makineModel;
    }

    public void setMakineModel(String makineModel) {
        this.makineModel = makineModel;
    }

    public String getMakineKontrolcu() {
        return makineKontrolcu;
    }

    public void setMakineKontrolcu(String makineKontrolcu) {
        this.makineKontrolcu = makineKontrolcu;
    }

    public String getMakineDosyaYolu() {
        return makineDosyaYolu;
    }

    public void setMakineDosyaYolu(String makineDosyaYolu) {
        this.makineDosyaYolu = makineDosyaYolu;
    }

    public LocalDateTime getMakineKayitTarihi() {
        return makineKayitTarihi;
    }

    public void setMakineKayitTarihi(LocalDateTime makineKayitTarihi) {
        this.makineKayitTarihi = makineKayitTarihi;
    }
}

