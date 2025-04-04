public class Orc extends Enemy{
    public Orc(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public boolean basicattack(Actor player) {
        System.out.println(this.name + " svingar med en yxa!");
        return super.basicAttack(player);
    }


}
