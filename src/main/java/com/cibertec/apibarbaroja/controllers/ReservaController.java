package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
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
}
