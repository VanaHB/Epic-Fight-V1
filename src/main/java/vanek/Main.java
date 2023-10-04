package vanek;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(10);

        MyServices.drawLogo("Epic Fight");

        Fighter fighterOne = MyServices.createFighter("first");
        Fighter fighterTwo = MyServices.createFighter("second");
        Environment arena = new Environment("Arena",fighterOne,fighterTwo,dice);

        arena.startFighting();
    }
}