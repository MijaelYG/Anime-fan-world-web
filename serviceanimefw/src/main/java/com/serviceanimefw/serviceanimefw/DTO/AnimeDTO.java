package com.serviceanimefw.serviceanimefw.DTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AnimeDTO {
    private Long id;

    private Long id_tipo;

    private String nombre;

    private String descripcion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_estreno;
    
    private String estado;

    private Date fecha_prox_cap;
}
