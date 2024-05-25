package com.ardadev.sergiecode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardadev.sergiecode.entities.Heroe;
import com.ardadev.sergiecode.repositories.HeroesRepository;

@RestController
@RequestMapping("/heroe")
public class HeroeController {

  @Autowired
  private HeroesRepository heroesRepository;

  @GetMapping("/")
  public List<Heroe> getAllHeroes() {
    return heroesRepository.findAll();
  }

  @GetMapping("/{id}")
  public Heroe getHeroeById(@PathVariable Long id) {
    return heroesRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Heroe not found"));
  }

  @PostMapping
  public Heroe createHeroe(@RequestBody Heroe heroe) {
    return heroesRepository.save(heroe);
  }

  @PutMapping("/{id}")
  public Heroe updateHeroe(@PathVariable Long id, @RequestBody Heroe heroe) {
    Heroe heroeFinded = heroesRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Heroe not found"));

    heroeFinded.setName(heroe.getName());
    heroeFinded.setType(heroe.getType());

    return heroesRepository.save(heroeFinded);
  }

  @DeleteMapping("/{id}")
  public Heroe deleteHeroe(@PathVariable Long id) {
    Heroe heroe = heroesRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Heroe not found"));

    heroesRepository.deleteById(id);
    return heroe;
  }
}
