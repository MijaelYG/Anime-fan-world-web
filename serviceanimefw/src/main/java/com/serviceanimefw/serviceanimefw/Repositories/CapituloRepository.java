package com.serviceanimefw.serviceanimefw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serviceanimefw.serviceanimefw.Entity.Capitulo;

@Repository
public interface CapituloRepository extends JpaRepository<Capitulo, Long> {

}
