package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class AnimalController {
    @Value("${course.name}") private String courseName;
    @Value("${project.developer.fullName}") private String developerFullName;

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/workintech/animal")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimal(@PathVariable int id){
        if(id<0) {
            System.out.println("Wrong id");
            return null;
        }
        return this.animals.get(id);
    }

    @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/workintech/animal/{id}")
    public void update(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, new Animal(id, animal.getName()));
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal delete(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(animal);
        return animal;
    }

}
