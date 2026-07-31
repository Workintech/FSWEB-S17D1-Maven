package com.workintech.fswebs17d1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.workintech.fswebs17d1.entity.Animal;

@ExtendWith(ResultAnalyzer.class)
class FswebS17d1ApplicationTests {

    @Test
    void testAnimalCreation() {
        Integer expectedId = 1;
        String expectedName = "Lion";

        Animal animal = new Animal(expectedId, expectedName);

        assertEquals(expectedId, animal.getId(), "The ID should match the expected value.");
        assertEquals(expectedName, animal.getName(), "The name should match the expected value.");
    }
}

