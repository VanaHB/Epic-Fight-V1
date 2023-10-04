package vanek;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class MyServices {

    public static void drawLogo(String nameOfEnvironment) {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        try {
            artGen.printTextArt(String.format("Welcome to the %s",nameOfEnvironment), ASCIIArtGenerator.ART_SIZE_SMALL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Fighter createFighter(String playerNote) {
        System.out.printf("Create %s player. Obey - strength and protection has to sum 10.%n", playerNote);
        String fighterName = "";
        int fighterStrenght = 0;
        int fighterProtection = 0;
        Scanner sc = new Scanner(System.in);

        System.out.printf("Input name (empty name means generate player automatically): ");
        fighterName = readString(sc);
        if (fighterName.length() > 0) {
            while ( (fighterStrenght + fighterProtection) != 10) {
                System.out.printf("Input strength: ");
                fighterStrenght = readInt(sc);
                System.out.printf("Input protection: ");
                fighterProtection = readInt(sc);

                if ((fighterStrenght + fighterProtection) != 10) {
                    System.out.printf("Strength and protection does not sum 10. Pleace enter again.%n");
                }
            }
        } else {
            //no mane given means automatic generating
            fighterName = String.format("%s player", playerNote.substring(0,1).toUpperCase()+playerNote.substring(1));
            Random random = new Random();
            fighterStrenght = random.nextInt(10)+1;
            fighterProtection = 10 - fighterStrenght;
        }

        System.out.printf("%n");
        return new Fighter(fighterName, fighterStrenght, fighterProtection);
    }

    public static String readString(Scanner sc) {
        boolean inputIsCorrect = false;
        String inputValue = "";

        while (!inputIsCorrect) {
            try {
                inputValue = sc.nextLine();
                if (inputValue.length() >= 0) { //this if is not used now
                    inputIsCorrect = true;
                } else {
                    System.out.printf("String has to be given. Do again.%n");
                }
            } catch (NoSuchElementException ex) {
                System.out.printf("%s%n",ex.getMessage());
            }
        }
        return inputValue;
    }

    public static int readInt(Scanner sc) {
        boolean inputIsCorrect = false;
        int inputValue = 0;

        while (!inputIsCorrect) {
            try {
                inputValue = Integer.parseInt(sc.nextLine());
                inputIsCorrect = true;
            } catch (NumberFormatException ex) {
                System.out.printf("Input is not a number. Do again.%n");
            }
        }
        return inputValue;
    }
}
