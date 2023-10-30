package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<ReservaEntity, Integer> implements ReservaService{
    public ReservaServiceImpl(BaseRepository<ReservaEntity, Integer> baseRepository) {
        super(baseRepository);
    }
}