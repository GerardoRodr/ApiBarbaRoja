package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.ClienteEntity;
import org.springframework.http.ResponseEntity;

public interface ClienteService extends BaseService<ClienteEntity, Integer>{
    ResponseEntity<?> loginCliente(String correo, String pass);
}