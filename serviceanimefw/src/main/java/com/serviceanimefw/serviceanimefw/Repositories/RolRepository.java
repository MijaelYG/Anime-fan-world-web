package com.serviceanimefw.serviceanimefw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serviceanimefw.serviceanimefw.Entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
