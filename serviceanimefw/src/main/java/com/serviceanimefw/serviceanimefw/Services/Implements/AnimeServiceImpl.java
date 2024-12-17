package com.serviceanimefw.serviceanimefw.Services.Implements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceanimefw.serviceanimefw.DTO.AnimeDTO;
import com.serviceanimefw.serviceanimefw.Entity.Anime;
import com.serviceanimefw.serviceanimefw.Entity.Tipo;
import com.serviceanimefw.serviceanimefw.Repositories.AnimeRepository;
import com.serviceanimefw.serviceanimefw.Repositories.TipoRepository;
import com.serviceanimefw.serviceanimefw.Services.Service.AnimeService;

@Service
public class AnimeServiceImpl implements AnimeService{

    @Autowired
    AnimeRepository animeRepository;

    @Autowired
    TipoRepository tipoRepository;


    @Override
    public List<AnimeDTO> ObtenerTodosLosAnimes() {
        List<Anime> anime = animeRepository.findAll();
        return anime.stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public String AgregarAnime(AnimeDTO animeDTO) {
        Optional<Tipo> tipo = tipoRepository.findById(animeDTO.getId());
        if(tipo.isPresent()){
            Anime anime = mapearEntidad(animeDTO);
            anime.setTipo(tipo.get());
            animeRepository.save(anime);
            return "El Anime fue agregado correctamente.";
        }else{
            return "El Tipo no existe.";
        }
    }

    
    private AnimeDTO mapearDTO(Anime anime) {
        AnimeDTO animeDTO = new AnimeDTO();

        animeDTO.setId(anime.getId());
        animeDTO.setNombre(anime.getNombre());
        animeDTO.setDescripcion(anime.getDescripcion());
        animeDTO.setFecha_estreno(anime.getFecha_estreno());
        animeDTO.setId_tipo(anime.getTipo().getId());
        animeDTO.setFecha_prox_cap(anime.getFecha_prox_capitulo());
        animeDTO.setEstado(anime.getEstado());

        return animeDTO;
    }

    private Anime mapearEntidad(AnimeDTO animeDTO) {
        Anime anime = new Anime();
        anime.setId(animeDTO.getId());
        anime.setNombre(animeDTO.getNombre());
        anime.setDescripcion(animeDTO.getDescripcion());
        anime.setFecha_estreno(animeDTO.getFecha_estreno());
        anime.setFecha_prox_capitulo(animeDTO.getFecha_prox_cap());
        anime.setEstado(animeDTO.getEstado());

        return anime;
    }


}
