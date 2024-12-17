package com.serviceanimefw.serviceanimefw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serviceanimefw.serviceanimefw.Entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {

}
