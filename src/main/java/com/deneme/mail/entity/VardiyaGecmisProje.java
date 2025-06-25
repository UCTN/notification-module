package com.deneme.mail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
@Table(name = "vardiya_gecmis_proje")
public class VardiyaGecmisProje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vardiya_baslangic_tarihi")
    private LocalDateTime vardiyaStart;

    @Column(name = "vardiya_bitis_tarihi")
    private LocalDateTime vardiyaEnd;

    @Column(name = "kayit_tarihi")
    private LocalDateTime kayitTarihi;

    @Column(name = "planli_calisma_suresi", nullable = true)
    @Min(0)
    private Double planliCalismaSuresi;

    @Column(name = "calisma_suresi")
    @Min(0)
    private Double calismaSuresi;

    private long planliDurus = 0;

    private long plansizDurus = 0;

    private long zorunluDurus = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proje_id")
    private Proje proje;

    @Column(name = "toplam_kirilan_uc_sayisi", nullable = true)
    private long toplamKirilanUcSayisi;

    @OneToOne
    @JoinColumn(name = "verimlilik_proje_id")
    private VerimlilikProje verimlilikProje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vardiya_gecmisi_id")
    private VardiyaGecmisi vardiyaGecmisi;

    public VardiyaGecmisProje() {
        this.kayitTarihi = LocalDateTime.now();
    }

    public VardiyaGecmisProje(Long id, LocalDateTime vardiyaStart, LocalDateTime vardiyaEnd, LocalDateTime kayitTarihi,
                              Double planliCalismaSuresi, Double calismaSuresi, long planliDurus, long plansizDurus, long zorunluDurus,
                              Proje proje, long toplamKirilanUcSayisi, VerimlilikProje verimlilikProje, VardiyaGecmisi vardiyaGecmisi) {
        this.id = id;
        this.vardiyaStart = vardiyaStart;
        this.vardiyaEnd = vardiyaEnd;
        this.kayitTarihi = kayitTarihi;
        this.planliCalismaSuresi = planliCalismaSuresi;
        this.calismaSuresi = calismaSuresi;
        this.planliDurus = planliDurus;
        this.plansizDurus = plansizDurus;
        this.zorunluDurus = zorunluDurus;
        this.proje = proje;
        this.toplamKirilanUcSayisi = toplamKirilanUcSayisi;
        this.verimlilikProje = verimlilikProje;
        this.vardiyaGecmisi = vardiyaGecmisi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVardiyaStart() {
        return vardiyaStart;
    }

    public void setVardiyaStart(LocalDateTime vardiyaStart) {
        this.vardiyaStart = vardiyaStart;
    }

    public LocalDateTime getVardiyaEnd() {
        return vardiyaEnd;
    }

    public void setVardiyaEnd(LocalDateTime vardiyaEnd) {
        this.vardiyaEnd = vardiyaEnd;
    }

    public LocalDateTime getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(LocalDateTime kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Double getPlanliCalismaSuresi() {
        return planliCalismaSuresi;
    }

    public void setPlanliCalismaSuresi(Double planliCalismaSuresi) {
        this.planliCalismaSuresi = planliCalismaSuresi;
    }

    public Double getCalismaSuresi() {
        return calismaSuresi;
    }

    public void setCalismaSuresi(Double calismaSuresi) {
        this.calismaSuresi = calismaSuresi;
    }

    public long getPlanliDurus() {
        return planliDurus;
    }

    public void setPlanliDurus(long planliDurus) {
        this.planliDurus = planliDurus;
    }

    public long getPlansizDurus() {
        return plansizDurus;
    }

    public void setPlansizDurus(long plansizDurus) {
        this.plansizDurus = plansizDurus;
    }

    public long getZorunluDurus() {
        return zorunluDurus;
    }

    public void setZorunluDurus(long zorunluDurus) {
        this.zorunluDurus = zorunluDurus;
    }

    public Proje getProje() {
        return proje;
    }

    public void setProje(Proje proje) {
        this.proje = proje;
    }

    public long getToplamKirilanUcSayisi() {
        return toplamKirilanUcSayisi;
    }

    public void setToplamKirilanUcSayisi(long toplamKirilanUcSayisi) {
        this.toplamKirilanUcSayisi = toplamKirilanUcSayisi;
    }

    public VerimlilikProje getVerimlilikProje() {
        return verimlilikProje;
    }

    public void setVerimlilikProje(VerimlilikProje verimlilikProje) {
        this.verimlilikProje = verimlilikProje;
    }

    public VardiyaGecmisi getVardiyaGecmisi() {
        return vardiyaGecmisi;
    }

    public void setVardiyaGecmisi(VardiyaGecmisi vardiyaGecmisi) {
        this.vardiyaGecmisi = vardiyaGecmisi;
    }
}

