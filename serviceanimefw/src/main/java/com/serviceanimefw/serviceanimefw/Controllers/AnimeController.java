package com.serviceanimefw.serviceanimefw.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serviceanimefw.serviceanimefw.DTO.AnimeDTO;
import com.serviceanimefw.serviceanimefw.Services.Service.AnimeService;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    AnimeService animeService;

    @GetMapping()
    public ResponseEntity<?> BuscarTodos() {
        try {
           List<AnimeDTO> animeDTO = animeService.ObtenerTodosLosAnimes();
            return new ResponseEntity<>(animeDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarPorId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>("GetOne Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> AgregarAnime(@RequestBody AnimeDTO animeDTO) {
        try {
            String respuesta = animeService.AgregarAnime(animeDTO);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<?> ActualizarAnime(@RequestBody AnimeDTO animeDTO) {
        try {

            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarAnime(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
