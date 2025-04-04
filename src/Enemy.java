public abstract class Enemy extends Actor{


    public Enemy(String name, int health, int damage) {
        super(name, health, damage);
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


    public  boolean basicattack(Actor player){
        return super.basicAttack(player);

    }
}
