package com.serviceanimefw.serviceanimefw.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private Long id;

    private Long id_rol;

    private String nombres;

    private String apellidos;

    private String correo;

    private String usuario;

    private String password;

    private String estado;
}
