package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.ClienteEntity;
import com.cibertec.apibarbaroja.services.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/clientes")
public class ClienteController extends BaseControllerImpl<ClienteEntity, ClienteServiceImpl>{
}
