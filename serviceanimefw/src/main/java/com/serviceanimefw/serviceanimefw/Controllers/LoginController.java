package com.serviceanimefw.serviceanimefw.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceanimefw.serviceanimefw.DTO.LoginUsuarioDTO;
import com.serviceanimefw.serviceanimefw.Services.Service.LoginService;


@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/iniciar")
    public ResponseEntity<?> LoginUsuario(@RequestBody LoginUsuarioDTO loginUsuarioDTO) {
        try {
            LoginUsuarioDTO respuesta = loginService.LoginUsuario(loginUsuarioDTO.getUsuario(), loginUsuarioDTO.getPassword());
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
