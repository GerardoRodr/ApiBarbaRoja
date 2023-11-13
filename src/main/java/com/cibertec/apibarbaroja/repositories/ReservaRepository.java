package com.cibertec.apibarbaroja.repositories;

import com.cibertec.apibarbaroja.entities.ReservaEntity;

import java.util.List;

public interface ReservaRepository extends BaseRepository<ReservaEntity, Integer>{
    List<ReservaEntity> findByCliente_Id(int cliente_id);
}
