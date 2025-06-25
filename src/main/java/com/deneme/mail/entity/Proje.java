package com.deneme.mail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Proje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proje_adi", length = 200, nullable = false)
    private String projeAdi;

    @Column(name = "proje_aciklamasi", length = 500, nullable = false)
    private String projeAciklamasi;

    @Column(name = "malzeme_turu", length = 100, nullable = false)
    private String malzemeTuru;

    @Column(name = "uretilen_malzeme_adi", nullable = false)
    @Min(1)
    private int uretilecekAdet;

    @Column(name = "uretilen_adet")
    private int uretilenAdet;

    @Column(name = "tahmini_uretim_suresi")
    private String tahminiUretimSuresi;

    @Column(name = "kayit_tarih")
    private LocalDateTime kayit_tarih;

    @Column(name = "baslangic_tarih")
    private String baslangicTarih;

    @Column(name = "bitis_tarih")
    private String bitisTarih;

    @ManyToMany
    @JoinTable(
            name = "user_proje",
            joinColumns = @JoinColumn(name = "proje_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public Proje() {
        this.kayit_tarih = LocalDateTime.now();
    }

    public Proje(Long id, String projeAdi, String projeAciklamasi, String malzemeTuru, int uretilecekAdet, int uretilenAdet,
                 String tahminiUretimSuresi, LocalDateTime kayit_tarih, String baslangicTarih, String bitisTarih, List<User> users) {
        this.id = id;
        this.projeAdi = projeAdi;
        this.projeAciklamasi = projeAciklamasi;
        this.malzemeTuru = malzemeTuru;
        this.uretilecekAdet = uretilecekAdet;
        this.uretilenAdet = uretilenAdet;
        this.tahminiUretimSuresi = tahminiUretimSuresi;
        this.kayit_tarih = kayit_tarih;
        this.baslangicTarih = baslangicTarih;
        this.bitisTarih = bitisTarih;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjeAdi() {
        return projeAdi;
    }

    public void setProjeAdi(String projeAdi) {
        this.projeAdi = projeAdi;
    }

    public String getProjeAciklamasi() {
        return projeAciklamasi;
    }

    public void setProjeAciklamasi(String projeAciklamasi) {
        this.projeAciklamasi = projeAciklamasi;
    }

    public String getMalzemeTuru() {
        return malzemeTuru;
    }

    public void setMalzemeTuru(String malzemeTuru) {
        this.malzemeTuru = malzemeTuru;
    }

    public int getUretilecekAdet() {
        return uretilecekAdet;
    }

    public void setUretilecekAdet(int uretilecekAdet) {
        this.uretilecekAdet = uretilecekAdet;
    }

    public int getUretilenAdet() {
        return uretilenAdet;
    }

    public void setUretilenAdet(int uretilenAdet) {
        this.uretilenAdet = uretilenAdet;
    }

    public String getTahminiUretimSuresi() {
        return tahminiUretimSuresi;
    }

    public void setTahminiUretimSuresi(String tahminiUretimSuresi) {
        this.tahminiUretimSuresi = tahminiUretimSuresi;
    }

    public LocalDateTime getKayit_tarih() {
        return kayit_tarih;
    }

    public void setKayit_tarih(LocalDateTime kayit_tarih) {
        this.kayit_tarih = kayit_tarih;
    }

    public String getBaslangicTarih() {
        return baslangicTarih;
    }

    public void setBaslangicTarih(String baslangicTarih) {
        this.baslangicTarih = baslangicTarih;
    }

    public String getBitisTarih() {
        return bitisTarih;
    }

    public void setBitisTarih(String bitisTarih) {
        this.bitisTarih = bitisTarih;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

