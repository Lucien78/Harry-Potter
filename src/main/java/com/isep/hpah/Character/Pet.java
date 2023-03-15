package com.isep.hpah.Character;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Pet {
    private static final List<String> PET_TYPES = Arrays.asList(
            "Rat",
            "Cat",
            "Owl"
    );

    private String type;

    public Pet() {
        this.type = assignPet();
    }

    public static String assignPet() {
        Random rand = new Random();
        return PET_TYPES.get(rand.nextInt(PET_TYPES.size()));
    }
}

