package mani.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuperHeroes {
    Map<String,ArrayList<SuperHero>> heroType = new HashMap<>();

    class SuperHero {
        String superHeroName;
        String universe;
        String superPower;
        String dob;

        SuperHero(String superHeroName, String universe, String superPower, String dob) {
            superHeroName = this.superHeroName;
            universe = this.universe;
            superPower = this.superPower;
            dob = this.dob;
        }
    }
}
