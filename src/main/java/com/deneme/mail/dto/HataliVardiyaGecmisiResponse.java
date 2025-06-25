package com.deneme.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HataliVardiyaGecmisiResponse {

    private long vardiyaGecmisiId;
    private String vardiyaBaslangicTarihi;
    private String vardiyaBitisTarihi;

    public HataliVardiyaGecmisiResponse(long vardiyaGecmisiId, String vardiyaBaslangicTarihi, String vardiyaBitisTarihi) {
        this.vardiyaGecmisiId = vardiyaGecmisiId;
        this.vardiyaBaslangicTarihi = vardiyaBaslangicTarihi;
        this.vardiyaBitisTarihi = vardiyaBitisTarihi;
    }
}
