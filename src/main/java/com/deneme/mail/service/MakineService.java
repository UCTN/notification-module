package com.deneme.mail.service;

import com.deneme.mail.dto.MakineResponse;
import com.deneme.mail.entity.Makine;
import com.deneme.mail.repository.HataliVardiyaGecmisiRepository;
import com.deneme.mail.repository.MakineRepository;
import com.deneme.mail.service.base.AbstractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MakineService extends AbstractService<Makine> {

    private final MakineRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public MakineRepository getRepository() {
        return repository;
    }

    public List<MakineResponse> getAll(){
        List<Makine> makineList = super.findAll();
        return makineList
                .stream()
                .map(makine -> modelMapper.map(makine, MakineResponse.class))
                .toList();
    }
}

