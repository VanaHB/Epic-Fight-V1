package vanek;

import java.util.Random;

public class Dice {
    private int sites;
    Random rollOfRandom = new Random();

    public Dice() {     //default dice has got 6 sites
        this.sites = 6;
    }

    public Dice(int sites) {
        this.sites = sites;
    }

    public int roll() {
        return rollOfRandom.nextInt(sites)+1;
    }
}
