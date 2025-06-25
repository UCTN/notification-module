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
@Table(name = "vardiya_gecmisi")
public class VardiyaGecmisi {

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

    @Column(name = "toplam_kirilan_uc_sayisi", nullable = true)
    private long toplamKirilanUcSayisi;

    @Column(name = "vardiya_calisma_sayaci", nullable = true)
    private String vardiyaCalismaSayaci;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verimlilik_id")
    private Verimlilik verimlilik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "makine_id")
    private Makine makine;

    public VardiyaGecmisi() {
        this.kayitTarihi = LocalDateTime.now();
    }

    public VardiyaGecmisi(Long id, LocalDateTime vardiyaStart, LocalDateTime vardiyaEnd, LocalDateTime kayitTarihi,
                          Double planliCalismaSuresi, Double calismaSuresi, long toplamKirilanUcSayisi, String vardiyaCalismaSayaci,
                          User user, Verimlilik verimlilik, Makine makine) {
        this.id = id;
        this.vardiyaStart = vardiyaStart;
        this.vardiyaEnd = vardiyaEnd;
        this.kayitTarihi = kayitTarihi;
        this.planliCalismaSuresi = planliCalismaSuresi;
        this.calismaSuresi = calismaSuresi;
        this.toplamKirilanUcSayisi = toplamKirilanUcSayisi;
        this.vardiyaCalismaSayaci = vardiyaCalismaSayaci;
        this.user = user;
        this.verimlilik = verimlilik;
        this.makine = makine;
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

    public long getToplamKirilanUcSayisi() {
        return toplamKirilanUcSayisi;
    }

    public void setToplamKirilanUcSayisi(long toplamKirilanUcSayisi) {
        this.toplamKirilanUcSayisi = toplamKirilanUcSayisi;
    }

    public String getVardiyaCalismaSayaci() {
        return vardiyaCalismaSayaci;
    }

    public void setVardiyaCalismaSayaci(String vardiyaCalismaSayaci) {
        this.vardiyaCalismaSayaci = vardiyaCalismaSayaci;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Verimlilik getVerimlilik() {
        return verimlilik;
    }

    public void setVerimlilik(Verimlilik verimlilik) {
        this.verimlilik = verimlilik;
    }

    public Makine getMakine() {
        return makine;
    }

    public void setMakine(Makine makine) {
        this.makine = makine;
    }
}


