package com.deneme.mail.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class HataliVardiyaGecmisiRequest {

    private long VardiyaGecmisiId;
    private LocalDateTime vardiyaBaslangicTarihi;
    private LocalDateTime vardiyaBitisTarihi;

    public HataliVardiyaGecmisiRequest(long vardiyaGecmisiId, LocalDateTime vardiyaBaslangicTarihi, LocalDateTime vardiyaBitisTarihi) {
        VardiyaGecmisiId = vardiyaGecmisiId;
        this.vardiyaBaslangicTarihi = vardiyaBaslangicTarihi;
        this.vardiyaBitisTarihi = vardiyaBitisTarihi;
    }

}
