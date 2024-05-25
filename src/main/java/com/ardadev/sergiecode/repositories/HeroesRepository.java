package com.ardadev.sergiecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardadev.sergiecode.entities.Heroe;

public interface HeroesRepository extends JpaRepository<Heroe, Long> {
}
