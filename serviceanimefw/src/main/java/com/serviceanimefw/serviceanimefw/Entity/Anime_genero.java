package com.serviceanimefw.serviceanimefw.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "anime_genero")
public class Anime_genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anime_genero")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_anime")
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero; 
}
