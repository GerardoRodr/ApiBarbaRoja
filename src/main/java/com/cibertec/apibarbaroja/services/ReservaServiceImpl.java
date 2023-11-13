package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import com.cibertec.apibarbaroja.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<ReservaEntity, Integer> implements ReservaService{

    @Autowired
    private ReservaRepository reservaRepository;

    public ReservaServiceImpl(BaseRepository<ReservaEntity, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ReservaEntity> reservasPorCliente(int idCliente) throws Exception {
        try {
            return reservaRepository.findByCliente_Id(idCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}