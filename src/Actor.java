import java.util.Random;

public class Actor {

    protected String name;
    protected int health;
    protected int damage;

    public Actor(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public boolean basicAttack(Actor enemy){

        Random rng = new Random();
        int variance = rng.nextInt(-2,3);
        int trueDamage = damage + variance;
        boolean enemyIsAlive =  enemy.takeDamage(trueDamage);
        return enemyIsAlive;

    }

    public boolean takeDamage(int damage){
        this.health -= damage;
        System.out.println(this.name + " tog " + damage + " i skada.");
        System.out.println(this.name + " hälsa är nu " + this.health);

        if(this.health <= 0){
            System.out.println(this.name + " dog!");
            return false;
        }

        return true;
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
