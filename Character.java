public class Character {
    String name;
    int health = 100, potions = 5, damage;

    Character() {
        this.name = "";
        this.potions = 0;
        this.damage = 0;
    }

    Character(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getPotions() {
        return potions;
    }

    public int getdamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPotions(int potions) {
        this.potions = potions;
    }
}