package com.serviceanimefw.serviceanimefw.Services.Service;

import com.serviceanimefw.serviceanimefw.DTO.LoginUsuarioDTO;

public interface LoginService {

    LoginUsuarioDTO LoginUsuario(String usuario, String password);
}
