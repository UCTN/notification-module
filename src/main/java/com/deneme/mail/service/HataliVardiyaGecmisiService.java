package com.deneme.mail.service;

import com.deneme.mail.dto.HataliVardiyaGecmisiRequest;
import com.deneme.mail.dto.HataliVardiyaGecmisiResponse;
import com.deneme.mail.entity.HataliVardiyaGecmisi;
import com.deneme.mail.entity.VardiyaGecmisi;
import com.deneme.mail.repository.HataliVardiyaGecmisiRepository;
import com.deneme.mail.service.base.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HataliVardiyaGecmisiService extends AbstractService<HataliVardiyaGecmisi> {

    private final HataliVardiyaGecmisiRepository hataliVardiyaGecmisiRepository;
    private final VardiyaGecmisiService vardiyaGecmisiService;
    private final ModelMapper modelmapper;

    @Override
    protected HataliVardiyaGecmisiRepository getRepository() {
        return hataliVardiyaGecmisiRepository;
    }

    public String create(HataliVardiyaGecmisiRequest hataliVardiyaGecmisiRequest) {
       VardiyaGecmisi vardiyaGecmisi = vardiyaGecmisiService.findById(hataliVardiyaGecmisiRequest.getVardiyaGecmisiId());

       if (vardiyaGecmisi == null) {
           log.error("VardiyaGecmisi not found with id: {}", hataliVardiyaGecmisiRequest.getVardiyaGecmisiId());
           throw new IllegalArgumentException("VardiyaGecmisi not found");
       }

       HataliVardiyaGecmisi hataliVardiyaGecmisi = new HataliVardiyaGecmisi();
       hataliVardiyaGecmisi.setVardiyaGecmisi(vardiyaGecmisi);
       hataliVardiyaGecmisi.setVardiyaBaslangicTarihi(hataliVardiyaGecmisiRequest.getVardiyaBaslangicTarihi());
       hataliVardiyaGecmisi.setVardiyaBitisTarihi(hataliVardiyaGecmisiRequest.getVardiyaBitisTarihi());

       getRepository().save(hataliVardiyaGecmisi);

       return "Hatali vardiya gecmisi basariyla olusturuldu: " + hataliVardiyaGecmisi.getId();
    }

    public List<HataliVardiyaGecmisi> getAll() {
        return super.findAll();
    }

    public HataliVardiyaGecmisiResponse getById(Long id) {
        HataliVardiyaGecmisi hataliVardiyaGecmisi = super.findById(id);
        return modelmapper.map(hataliVardiyaGecmisi, HataliVardiyaGecmisiResponse.class);
    }

    public List<HataliVardiyaGecmisiResponse> getHataliVardiyaGecmisiToday(){
        List<HataliVardiyaGecmisi> hataliVardiyaGecmisiList = getRepository().findByVardiyaBaslangicTarihiToday();
        return hataliVardiyaGecmisiList
                .stream()
                .map(hataliVardiyaGecmisi -> modelmapper.map(hataliVardiyaGecmisi, HataliVardiyaGecmisiResponse.class))
                .toList();
    }
}
