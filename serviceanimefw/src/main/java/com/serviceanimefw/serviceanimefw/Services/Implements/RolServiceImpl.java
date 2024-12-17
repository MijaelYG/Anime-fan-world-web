package com.serviceanimefw.serviceanimefw.Services.Implements;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceanimefw.serviceanimefw.DTO.RolDTO;
import com.serviceanimefw.serviceanimefw.Entity.Rol;
import com.serviceanimefw.serviceanimefw.Repositories.RolRepository;
import com.serviceanimefw.serviceanimefw.Services.Service.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<RolDTO> ObtenerTodosLosRoles() {
        List<Rol> rol = rolRepository.findAll();
        return rol.stream().map(this::mapearDTO).collect(Collectors.toList());
    }
    

    private RolDTO mapearDTO(Rol rol) {
        RolDTO rolDTO = new RolDTO();

        rolDTO.setId(rol.getId());
        rolDTO.setRol(rol.getRol());

        return rolDTO;
    }
}
