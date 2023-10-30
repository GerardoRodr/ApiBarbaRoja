package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.AdministradorEntity;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl extends BaseServiceImpl<AdministradorEntity, Integer> implements AdministradorService{
    public AdministradorServiceImpl(BaseRepository<AdministradorEntity, Integer> baseRepository) {
        super(baseRepository);
    }
}