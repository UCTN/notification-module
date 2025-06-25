package com.deneme.mail.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
@Table(name = "vardiya")
public class Vardiya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Column(name = "vardiya_num", nullable = false)
    private int vardiyaNum;

    @Min(0)
    @Column(name = "calisma_suresi", nullable = false)
    private int calismaSuresi;

    @Min(0)
    @Column(name = "mola_suresi", nullable = false)
    private int molaSuresi;

    @Column(name = "gun", length = 20, nullable = false)
    private String gun;

    @Column(name = "vardiya_baslangic", nullable = false)
    private LocalDateTime vardiyaBaslangic;

    @Column(name = "vardiya_bitis", nullable = false)
    private LocalDateTime vardiyaBitis;

    public Vardiya() {
    }

    public Vardiya(Long id, int vardiyaNum, int calismaSuresi, int molaSuresi,
                   String gun, LocalDateTime vardiyaBaslangic, LocalDateTime vardiyaBitis) {
        this.id = id;
        this.vardiyaNum = vardiyaNum;
        this.calismaSuresi = calismaSuresi;
        this.molaSuresi = molaSuresi;
        this.gun = gun;
        this.vardiyaBaslangic = vardiyaBaslangic;
        this.vardiyaBitis = vardiyaBitis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVardiyaNum() {
        return vardiyaNum;
    }

    public void setVardiyaNum(int vardiyaNum) {
        this.vardiyaNum = vardiyaNum;
    }

    public int getCalismaSuresi() {
        return calismaSuresi;
    }

    public void setCalismaSuresi(int calismaSuresi) {
        this.calismaSuresi = calismaSuresi;
    }

    public int getMolaSuresi() {
        return molaSuresi;
    }

    public void setMolaSuresi(int molaSuresi) {
        this.molaSuresi = molaSuresi;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public LocalDateTime getVardiyaBaslangic() {
        return vardiyaBaslangic;
    }

    public void setVardiyaBaslangic(LocalDateTime vardiyaBaslangic) {
        this.vardiyaBaslangic = vardiyaBaslangic;
    }

    public LocalDateTime getVardiyaBitis() {
        return vardiyaBitis;
    }

    public void setVardiyaBitis(LocalDateTime vardiyaBitis) {
        this.vardiyaBitis = vardiyaBitis;
    }
}

