package com.cibertec.apibarbaroja.repositories;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends BaseRepository<ReservaEntity, Integer>{
    List<ReservaEntity> findByCliente_Id(int cliente_id);

    // USANDO SQL NATIVO
    @Transactional
    @Modifying
    @Query(value = "UPDATE ReservaEntity r SET r.estado = :estado WHERE r.id = :id")
    void updateEstadoById(@Param("id") Integer id, @Param("estado") String estado);
}
