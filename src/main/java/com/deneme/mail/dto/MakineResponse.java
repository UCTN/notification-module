package com.deneme.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MakineResponse {

    private String makineAdi;
    private String makineKodu;
    private String makineMarka;
    private String makineModel;
    private String makineKontrolcu;
    private LocalDateTime makineKayitTarihi;

    public MakineResponse(String makineAdi, String makineKodu, String makineMarka,
                          String makineModel, String makineKontrolcu, LocalDateTime makineKayitTarihi) {

        this.makineAdi = makineAdi;
        this.makineKodu = makineKodu;
        this.makineMarka = makineMarka;
        this.makineModel = makineModel;
        this.makineKontrolcu = makineKontrolcu;
        this.makineKayitTarihi = makineKayitTarihi;
    }
}
