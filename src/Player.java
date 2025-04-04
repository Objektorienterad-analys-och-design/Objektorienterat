import java.util.Random;

public class Player extends Actor{

    public Player(String name, int health, int damage) {
        super(name, health, damage);

    }

    @Override
    public boolean basicAttack(Actor enemy){
        System.out.println("Spelaren " + this.name + " attackerar " + enemy.name);
        return super.basicAttack(enemy);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
