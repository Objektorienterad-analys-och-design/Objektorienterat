public class Orc extends Enemy{
    public Orc(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void basicattack(Player player) {
        System.out.println(this.name + " svingar med en yxa!");
        player.takeDamage(this.damage);
    }
}
