package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.AdministradorEntity;
import com.cibertec.apibarbaroja.services.AdministradorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/admins")
public class AdministradorController extends BaseControllerImpl<AdministradorEntity, AdministradorServiceImpl>{
    @Autowired
    private AdministradorServiceImpl administradorService;

    @PostMapping("/loginAdmin")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestBody) {
        String correo = requestBody.get("correo");
        String pass = requestBody.get("pass");

        ResponseEntity<?> respuesta = administradorService.loginAdmin(correo, pass);

        if (respuesta.getStatusCode().is2xxSuccessful()) {
            // Inicio de sesión exitoso: se accede a los datos del admin y al mensaje de éxito
            Map<String, Object> responseBody = (Map<String, Object>) respuesta.getBody();
            AdministradorEntity admin = (AdministradorEntity) responseBody.get("admin");
            String mensaje = (String) responseBody.get("mensaje");
            return ResponseEntity.ok(Map.of(
                    "admin", admin,
                    "mensaje", mensaje
            ));
        } else {
            // Inicio de sesión fallido: se devuelve el mensaje de error
            return ResponseEntity.status(respuesta.getStatusCode()).body(respuesta.getBody());
        }
    }
}