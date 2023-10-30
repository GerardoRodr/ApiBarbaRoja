package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.ServicioEntity;
import com.cibertec.apibarbaroja.services.ServicioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/servicios")
public class ServicioController extends BaseControllerImpl<ServicioEntity, ServicioServiceImpl>{
    //AQUI LA VAINA PA SUBIR IMGS
}
