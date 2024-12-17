package com.serviceanimefw.serviceanimefw.Services.Service;


import java.util.List;

import com.serviceanimefw.serviceanimefw.DTO.AnimeDTO;

public interface AnimeService {
    
    List<AnimeDTO> ObtenerTodosLosAnimes();
    String AgregarAnime(AnimeDTO animeDTO);
}
