package com.serviceanimefw.serviceanimefw.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serviceanimefw.serviceanimefw.Entity.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    
}
