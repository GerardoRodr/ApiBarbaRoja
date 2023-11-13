package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ReservaEntity;

import java.util.List;

public interface ReservaService extends BaseService<ReservaEntity, Integer>{
    List<ReservaEntity> reservasPorCliente(int idCliente) throws Exception;

    /*DONDE:
        estado 1: "PENDIENTE"
        estado 2: "FINALIZADA"
        estado 3: "CANCELADA"
     */
    String updateEstadoByIdReserva(int idReserva, int estado) throws Exception;
}
