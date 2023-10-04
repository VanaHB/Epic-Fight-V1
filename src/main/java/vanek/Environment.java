package vanek;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Environment {
    String name;
    Fighter fighterOne;
    Fighter fighterTwo;
    Dice dice;

    public Environment(String name, Fighter fighterOne, Fighter fighterTwo, Dice dice) {
        this.name = name;

        System.out.printf("%s%n",fighterOne);
        System.out.printf("%s%n",fighterTwo);
        //determining who is starting
        Random random = new Random();
        if (((random.nextInt(2)+1) == 1 )) {
            System.out.printf("%s is starting the fight!%n%n",fighterOne.getName());
            this.fighterOne = fighterOne;
            this.fighterTwo = fighterTwo;
        } else {
            System.out.printf("%s is starting the fight!%n%n",fighterTwo.getName());
            this.fighterOne = fighterTwo;
            this.fighterTwo = fighterOne;
        }

        this.dice = dice;
        fighterOne.setDice(dice);
        fighterTwo.setDice(dice);
    }

    public void startFighting() {
        int round = 1;
        while (fighterOne.isAlive() && fighterTwo.isAlive()) {
            System.out.printf("Round %d:%n",round);
            if (round%2 == 1) {
                fighterOne.attack(fighterTwo);
                draw(round);
            } else {
                fighterTwo.attack(fighterOne);
                draw(round);
            }
            round ++;
        }

        System.out.printf("%n");
        if (!fighterOne.isAlive()) {
            System.out.printf("The %s won the fight. The %s is alive no more.", fighterTwo.getName(), fighterOne.getName());
        } else {
            System.out.printf("The %s won the fight. The %s is alive no more.", fighterOne.getName(), fighterTwo.getName());
        }
    }

    public void draw(int round) {
        if (round%2 == 1) {
            System.out.println(fighterOne.getStatusMessage());
            System.out.println(fighterTwo.getStatusMessage());
            System.out.printf("%s stamina: %s%n",fighterOne.getName(),drawBars(fighterOne));
            System.out.printf("%s stamina: %s%n",fighterTwo.getName(),drawBars(fighterTwo));
        } else {
            System.out.println(fighterTwo.getStatusMessage());
            System.out.println(fighterOne.getStatusMessage());
            System.out.printf("%s stamina: %s%n",fighterOne.getName(),drawBars(fighterOne));
            System.out.printf("%s stamina: %s%n",fighterTwo.getName(),drawBars(fighterTwo));
        }
    }

    public String drawBars(Fighter fighter) {
        String bar = "";
        for (int i = 1; i < fighter.getStamina()+1; i++) {
            bar += "X";
        }
        return bar;
    }
}
