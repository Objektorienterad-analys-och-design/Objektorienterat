public abstract class Enemy {

    protected String name;
    protected int health;

    protected int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public abstract void basicattack(Player p);

    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println(this.name + " tar " + damage + " i skada.");
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
