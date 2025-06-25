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
@Table(name = "verimlilik")
public class Verimlilik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kalite", nullable = false)
    private Double kalite;

    @Column(name = "kullanilabilirlik", nullable = false)
    private Double kullanilabilirlik;

    @Column(name = "performans")
    private Double performans;

    @Column(name = "oee")
    private Double oee;

    @Column(name = "kullanim")
    private Double kullanim;

    @Column(name = "kayit_tarihi")
    private LocalDateTime kayitTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "makine_id")
    private Makine makine;

    public Verimlilik() {
        this.kayitTarihi = LocalDateTime.now();
    }

    public Verimlilik(Long id, Double kalite, Double kullanilabilirlik, Double performans, Double oee, Double kullanim, LocalDateTime kayitTarihi, Makine makine) {
        this.id = id;
        this.kalite = kalite;
        this.kullanilabilirlik = kullanilabilirlik;
        this.performans = performans;
        this.oee = oee;
        this.kullanim = kullanim;
        this.kayitTarihi = kayitTarihi;
        this.makine = makine;
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
}

