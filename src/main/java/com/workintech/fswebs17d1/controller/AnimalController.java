package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name:course-name}")
    private String courseName;

    @Value("${project.developer.fullname:developer}")
    private String projectDeveloperFullname;

    private final Map<Integer, Animal> animals = new HashMap<>();

    public AnimalController() {
        animals.put(1, new Animal(1, "maymun"));
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return ResponseEntity.ok(new ArrayList<>(animals.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer id) {
        Animal animal = animals.get(id);
        if (animal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animal);
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        if (!animals.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        animals.put(id, animal);
        return ResponseEntity.ok(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, String>> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("course.name", courseName);
        info.put("project.developer.fullname", projectDeveloperFullname);
        return ResponseEntity.ok(info);
    }
}
