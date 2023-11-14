package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
import com.cibertec.apibarbaroja.entities.ServicioMasLlamadoDTO;
import com.cibertec.apibarbaroja.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/reservas")
public class ReservaController extends BaseControllerImpl<ReservaEntity, ReservaServiceImpl> {

    @Autowired
    private ReservaServiceImpl reservaService;

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<?> reservasPorCliente(@PathVariable int idCliente) {
        try {
            List<ReservaEntity> reservas = reservaService.reservasPorCliente(idCliente);
            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            //Jajaja hay un monton de httpStatus, hay que usarlos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener reservas: " + e.getMessage());
        }
    }

    /*DONDE:
    estado 1: "PENDIENTE"
    estado 2: "FINALIZADA"
    estado 3: "CANCELADA"
    */
    @PutMapping("/actualizarEstado/{idReserva}")
    public ResponseEntity<?> actualizarEstadoReserva(@PathVariable Integer idReserva, @RequestParam Integer estado) {
        try {
            if (estado < 4) {
                String mensaje = reservaService.updateEstadoByIdReserva(idReserva, estado);
                return ResponseEntity.ok(mensaje);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Elija por favor un estado valido");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el estado de la reserva: " + e.getMessage());
        }
    }

    @GetMapping("/serviciosDestacados")
    public ResponseEntity<List<ServicioMasLlamadoDTO>> getServiciosMasLlamados() {
        List<ServicioMasLlamadoDTO> serviciosMasLlamados = reservaService.getServiciosMasLlamados();
        return ResponseEntity.ok(serviciosMasLlamados);
    }
}
