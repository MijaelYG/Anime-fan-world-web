package com.serviceanimefw.serviceanimefw.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceanimefw.serviceanimefw.DTO.GeneroDTO;
import com.serviceanimefw.serviceanimefw.Entity.Genero;
import com.serviceanimefw.serviceanimefw.Repositories.GeneroRepository;
import com.serviceanimefw.serviceanimefw.Services.Service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public List<GeneroDTO> ObtenerTodosLosGeneros() {
        List<Genero> generos = generoRepository.findAll();
        return generos.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public GeneroDTO ObtenerGeneroPorId(Long id) {
        Genero generos = generoRepository.findById(id).get();
        GeneroDTO generosDTO = mapearDTO(generos);
        return generosDTO;
    }

    @Override
    public String AgregarGenero(GeneroDTO generoDTO) {
        Genero generos = mapearEntidad(generoDTO);
        generoRepository.save(generos);
       return "El genero se ha creado correctamente";
    }

    @Override
    public String ActualizarGenero(GeneroDTO generodto) {
        if (generodto.getId() == null) {
            return "El ID es necesario para actualizar.";
        }
        Optional<Genero> generoexiste = generoRepository.findById(generodto.getId());
        if (generoexiste.isPresent()) {
            Genero generos = mapearEntidad(generodto);
            generoRepository.save(generos);
            return "El genero se ha actualizado correctamente.";
        } else {    
            return "El genero no existe. ";
        }

    }

    @Override
    public String EliminarGenero(Long id) {
        Optional<Genero> genero = generoRepository.findById(id);
        if(genero.isPresent()){
            generoRepository.deleteById(id);
            return "Genero eliminado correctamente";
        }else{
            return "Genero no encontrado";
        }
    }
    
    private GeneroDTO mapearDTO(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();

        generoDTO.setId(genero.getId());
        generoDTO.setGenero(genero.getGenero());

        return generoDTO;
    }

    private Genero mapearEntidad(GeneroDTO generoDTO) {
        Genero genero = new Genero();

        genero.setId(generoDTO.getId());
        genero.setGenero(generoDTO.getGenero());

        return genero;
    }

}
