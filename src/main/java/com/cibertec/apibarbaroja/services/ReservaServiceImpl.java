package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
import com.cibertec.apibarbaroja.entities.ServicioEntity;
import com.cibertec.apibarbaroja.entities.ServicioMasLlamadoDTO;
import com.cibertec.apibarbaroja.repositories.BaseRepository;
import com.cibertec.apibarbaroja.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public String updateEstadoByIdReserva(int idReserva, int estado) throws Exception {
        try {
            if (reservaRepository.existsById(idReserva)) {
                switch (estado){
                    case 1:
                        reservaRepository.updateEstadoById(idReserva, "PENDIENTE");
                        return "Estado de la reserva actualizado correctamente";
                    case 2:
                        reservaRepository.updateEstadoById(idReserva, "FINALIZADA");
                        return "Estado de la reserva actualizado correctamente";
                    case 3:
                        reservaRepository.updateEstadoById(idReserva, "CANCELADA");
                        return "Estado de la reserva actualizado correctamente";
                    default:
                        return "Ingrese un estado valido";
                }
            } else {
                return "La reserva no existe";
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar el estado de la reserva: " + e.getMessage());
        }
    }

    @Override
    public List<ServicioMasLlamadoDTO> getServiciosMasLlamados() {
        List<Object[]> resultados = reservaRepository.findServiciosMasLlamados();
        List<ServicioMasLlamadoDTO> serviciosMasLlamados = new ArrayList<>();

        for (Object[] resultado : resultados) {
            ServicioEntity servicio = (ServicioEntity) resultado[0];
            Long totalLlamadas = (Long) resultado[1];

            ServicioMasLlamadoDTO dto = new ServicioMasLlamadoDTO(servicio, totalLlamadas);
            serviciosMasLlamados.add(dto);
        }

        return serviciosMasLlamados;
    }

}