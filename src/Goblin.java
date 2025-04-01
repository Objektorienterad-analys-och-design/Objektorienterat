public class Goblin extends Enemy{


    public Goblin(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void basicattack(Player player) {
        System.out.println(this.name + " sticker med en dolk");
        player.takeDamage(this.damage);
    }


}
