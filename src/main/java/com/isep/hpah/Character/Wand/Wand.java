package com.isep.hpah.Character.Wand;
import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Wand {
    private static final List<String> CORES = Arrays.asList(
            "Ventricule de dragon",
            "Plume d'Oiseau-Tonnerre",
            "Plume de phénix",
            "Corne de Serpent cornu",
            "Corne de Basilic"
    );
    private double length;
    private String core;

    public Wand(double length, String core) {
        this.length = length;
        this.core = core;
    }

    public static Wand createRandomWand() {
        Random random = new Random();
        double randomLength = 25 + random.nextDouble() * 15;
        String randomCore = CORES.get(random.nextInt(CORES.size()));
        return new Wand(randomLength, randomCore);
    }
}
