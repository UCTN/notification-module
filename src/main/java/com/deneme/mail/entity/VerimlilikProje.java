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
@Table(name = "verimlilik_proje")
public class VerimlilikProje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kalite")
    private Double kalite; // Ürünlerin ne kadarının hatasız olduğu (Doğruluk oranı)

    @Column(name = "kullanilabilirlik")
    private Double kullanilabilirlik; // Makinenin ne kadar süre çalışabilir olduğu (Kullanılabilirlik oranı)

    @Column(name = "performans")
    private Double performans; // Makinenin ne kadar verimli çalıştığı (Performans oranı)

    @Column(name = "oee")
    private Double oee; // Genel Ekipman Verimliliği (OEE) hesaplaması için kullanılan formülün sonucu
                         // (OEE = Kalite * Kullanılabilirlik * Performans)

    @Column(name = "kullanim")
    private Double kullanim; // Makinenin ne kadar süre kullanıldığı (Kullanım oranı)

    @Column(name = "kayit_tarihi")
    private LocalDateTime kayitTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "makine_id")
    private Makine makine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proje_id")
    private Proje proje;

    public VerimlilikProje() {
        this.kayitTarihi = LocalDateTime.now();
    }

    public VerimlilikProje(Long id, Double kalite, Double kullanilabilirlik, Double performans,
                           Double oee, Double kullanim, LocalDateTime kayitTarihi, Makine makine, Proje proje) {
        this.id = id;
        this.kalite = kalite;
        this.kullanilabilirlik = kullanilabilirlik;
        this.performans = performans;
        this.oee = oee;
        this.kullanim = kullanim;
        this.kayitTarihi = kayitTarihi;
        this.makine = makine;
        this.proje = proje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKalite() {
        return kalite;
    }

    public void setKalite(Double kalite) {
        this.kalite = kalite;
    }

    public Double getKullanilabilirlik() {
        return kullanilabilirlik;
    }

    public void setKullanilabilirlik(Double kullanilabilirlik) {
        this.kullanilabilirlik = kullanilabilirlik;
    }

    public Double getPerformans() {
        return performans;
    }

    public void setPerformans(Double performans) {
        this.performans = performans;
    }

    public Double getOee() {
        return oee;
    }

    public void setOee(Double oee) {
        this.oee = oee;
    }

    public Double getKullanim() {
        return kullanim;
    }

    public void setKullanim(Double kullanim) {
        this.kullanim = kullanim;
    }

    public LocalDateTime getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDateTime kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Makine getMakine() {
        return makine;
    }

    public void setMakine(Makine makine) {
        this.makine = makine;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }
}

