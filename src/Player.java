import java.util.Random;

public class Player {

    protected String name;
    protected int health;
    protected int damage;

    public Player(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void basicAttack(Enemy enemy){


        System.out.println("Spelaren " + this.name + " attackerar " + enemy.name);
        Random rng = new Random();
        int variance = rng.nextInt(-2,3);
        int trueDamage = damage + variance;
        enemy.takeDamage(trueDamage);

    }

    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println(this.name + " tog " + damage + " i skada.");
        System.out.println(this.name + " hälsa är nu " + this.health);

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
