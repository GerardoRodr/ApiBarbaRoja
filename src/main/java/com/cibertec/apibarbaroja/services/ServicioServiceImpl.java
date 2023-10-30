package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ServicioEntity;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceImpl extends BaseServiceImpl<ServicioEntity, Integer> implements ServicioService{
    public ServicioServiceImpl(BaseRepository<ServicioEntity, Integer> baseRepository) {
        super(baseRepository);
    }
}