package com.serviceanimefw.serviceanimefw.DTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CapituloDTO {
    private Long id;

    private Long id_anime;

    private Long numero_capitulo;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_estreno;
    
    private String estado;
}
