public class Goblin extends Enemy{


    public Goblin(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public boolean basicattack(Actor enemy) {
        System.out.println(this.name + " sticker med en dolk");
       return super.basicAttack(enemy);
    }


}
