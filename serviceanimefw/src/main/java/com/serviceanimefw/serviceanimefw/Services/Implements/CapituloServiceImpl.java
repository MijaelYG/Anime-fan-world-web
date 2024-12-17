package com.serviceanimefw.serviceanimefw.Services.Implements;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceanimefw.serviceanimefw.DTO.CapituloDTO;
import com.serviceanimefw.serviceanimefw.Entity.Capitulo;
import com.serviceanimefw.serviceanimefw.Repositories.AnimeRepository;
import com.serviceanimefw.serviceanimefw.Repositories.CapituloRepository;
import com.serviceanimefw.serviceanimefw.Services.Service.CapituloService;

@Service
public class CapituloServiceImpl implements CapituloService{

    @Autowired
    CapituloRepository capituloRepository;

    @Autowired
    AnimeRepository animeRepository;

    @Override
    public List<CapituloDTO> ObtenerTodosLosCapitulosPorAnime() {
        List<Capitulo> capitulos = capituloRepository.findAll();
        return capitulos.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

     private CapituloDTO mapearDTO(Capitulo capitulo){
        CapituloDTO capituloDTO = new CapituloDTO();
        capituloDTO.setId(capitulo.getId());
        capituloDTO.setId_anime(capitulo.getAnime().getId());
        capituloDTO.setNumero_capitulo(capitulo.getNumero_capitulo());
        capituloDTO.setFecha_estreno(capitulo.getFecha_estreno());
        capituloDTO.setEstado(capitulo.getEstado());

        return capituloDTO;
    }

    /* 
    private Capitulo mapearEntidad(CapituloDTO capituloDTO){
        Capitulo capitulo = new Capitulo();
        capitulo.setId(capituloDTO.getId());
        capitulo.setNumero_capitulo(capituloDTO.getNumero_capitulo());
        capitulo.setFecha_estreno(capituloDTO.getFecha_estreno());
        capitulo.setEstado(capituloDTO.getEstado());

        return capitulo;
    }*/
    
}
