package com.cibertec.apibarbaroja.services;

import com.cibertec.apibarbaroja.entities.AdministradorEntity;
import org.springframework.http.ResponseEntity;

public interface AdministradorService extends BaseService<AdministradorEntity, Integer>{
    ResponseEntity<?> loginAdmin(String correo, String pass);
}
