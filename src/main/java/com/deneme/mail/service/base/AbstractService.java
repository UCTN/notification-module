package com.deneme.mail.service.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<T>{

    protected abstract JpaRepository<T, Long> getRepository();

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public T findById(Long id) {
        return getRepository().findById(id).orElseThrow(RuntimeException::new);
    }

}
