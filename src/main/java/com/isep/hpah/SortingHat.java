package com.isep.hpah;
import com.isep.hpah.Character.House;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

    public class SortingHat {
        private static final List<House> HOUSES = Arrays.asList(
                House.GRYFFINDOR,
                House.HUFFLEPUFF,
                House.RAVENCLAW,
                House.SLYTHERIN
        );

        public static House assignHouse() {
            Random random = new Random();
            return HOUSES.get(random.nextInt(HOUSES.size()));
        }
    }
