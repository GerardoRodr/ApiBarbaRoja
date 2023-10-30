package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.AdministradorEntity;
import com.cibertec.apibarbaroja.services.AdministradorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/admins")
public class AdministradorController extends BaseControllerImpl<AdministradorEntity, AdministradorServiceImpl>{
}