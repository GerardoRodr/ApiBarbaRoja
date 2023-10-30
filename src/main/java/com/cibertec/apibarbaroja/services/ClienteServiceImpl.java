package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ClienteEntity;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<ClienteEntity, Integer> implements ClienteService{
    public ClienteServiceImpl(BaseRepository<ClienteEntity, Integer> baseRepository) {
        super(baseRepository);
    }
}