package vanek;

public class Fighter {
    private String name;
    private int stamina;
    private int strenght;
    private int protection;
    private String statusMessage;
    private Dice dice;

    public Fighter(String name, int strenght, int protection) {
        this.name = name;
        this.stamina = 100;
        this.strenght = strenght;
        this.protection = protection;
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getProtection() {
        return protection;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void attack(Fighter prey) {
        int strengthOfAttack = strenght * dice.roll();
        statusMessage = name + " is attacking by strength of attack " + strengthOfAttack;
        prey.cover(strengthOfAttack);
    }

    public void cover(int strengthOfAttack) {
        int strengthOfCover = protection * dice.roll();
        statusMessage = name + " is covering by strength of cover " + strengthOfCover;
        int result = strengthOfCover - strengthOfAttack;
        if (result > 0) {
            stamina -= result;
        }
    }

    @Override
    public String toString() {
        return String.format("%s has strength of %d and protection of %d.", name, strenght, protection);
    }
}
