package com.serviceanimefw.serviceanimefw.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serviceanimefw.serviceanimefw.DTO.GeneroDTO;
import com.serviceanimefw.serviceanimefw.Services.Service.GeneroService;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping()
    public ResponseEntity<?> BuscarTodos() {
        try {
            List<GeneroDTO> generoDTOs = generoService.ObtenerTodosLosGeneros();
            return new ResponseEntity<>(generoDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarPorId(@PathVariable Long id) {
        try {
            GeneroDTO generoDTO = generoService.ObtenerGeneroPorId(id);
            return new ResponseEntity<>(generoDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PostMapping()
    public ResponseEntity<?> AgregarGenero(@RequestBody GeneroDTO generoDTOs) {
        try {
            String respuesta = generoService.AgregarGenero(generoDTOs);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping()
    public ResponseEntity<?> ActualizarGenero(@RequestBody GeneroDTO generoDTOs) {
        try {
            String respuesta = generoService.ActualizarGenero(generoDTOs);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            String respuesta = generoService.EliminarGenero(id);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
