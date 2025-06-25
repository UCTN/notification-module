package com.deneme.mail.service;

import com.deneme.mail.entity.VardiyaGecmisi;
import com.deneme.mail.repository.VardiyaGecmisiRepository;
import com.deneme.mail.service.base.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class VardiyaGecmisiService extends AbstractService<VardiyaGecmisi> {

    private final VardiyaGecmisiRepository vardiyaGecmisiRepository;

    @Override
    protected VardiyaGecmisiRepository getRepository() {
        return vardiyaGecmisiRepository;
    }

    public VardiyaGecmisi findById(Long id) {
        return super.findById(id);
    }
}
