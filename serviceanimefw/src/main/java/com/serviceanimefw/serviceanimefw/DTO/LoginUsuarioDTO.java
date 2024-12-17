package com.serviceanimefw.serviceanimefw.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginUsuarioDTO {

    private Long id;

    private String usuario;

    private String password;

    private String message;
}
