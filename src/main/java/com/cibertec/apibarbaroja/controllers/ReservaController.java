package com.cibertec.apibarbaroja.controllers;

import com.cibertec.apibarbaroja.entities.ReservaEntity;
import com.cibertec.apibarbaroja.services.ReservaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/reservas")
public class ReservaController extends BaseControllerImpl<ReservaEntity, ReservaServiceImpl>{
}
