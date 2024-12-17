package com.serviceanimefw.serviceanimefw.Services.Service;

import java.util.List;

import com.serviceanimefw.serviceanimefw.DTO.UsuarioDTO;

public interface UsuarioService {

    List<UsuarioDTO> ObtenerTodosLosUsuarios();
    UsuarioDTO ObtenerUsuarioPorId(Long id);
    String AgregarUsuario(UsuarioDTO usuarioDTO);
    String ActualizarUsuario(UsuarioDTO usuarioDTO);
}
