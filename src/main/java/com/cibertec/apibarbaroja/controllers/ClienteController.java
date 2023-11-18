package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.ClienteEntity;
import com.cibertec.apibarbaroja.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/clientes")
public class ClienteController extends BaseControllerImpl<ClienteEntity, ClienteServiceImpl> {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping("/loginCliente")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        String correo = requestBody.get("correo");
        String pass = requestBody.get("pass");

        ResponseEntity<?> respuesta = clienteService.loginCliente(correo, pass);

        if (respuesta.getStatusCode().is2xxSuccessful()) {
            // Inicio de sesión exitoso: se accede a los datos del cliente y al mensaje de éxito
            Map<String, Object> responseBody = (Map<String, Object>) respuesta.getBody();
            ClienteEntity cliente = (ClienteEntity) responseBody.get("cliente");
            String mensaje = (String) responseBody.get("mensaje");
            return ResponseEntity.ok(Map.of(
                    "cliente", cliente,
                    "mensaje", mensaje
            ));
        } else {
            // Inicio de sesión fallido: se devuelve el mensaje de error
            return ResponseEntity.status(respuesta.getStatusCode()).body(Map.of("mensajeError", respuesta.getBody()));
        }
    }
}