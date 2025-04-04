public class GoblinArcher extends Enemy implements RangedUnit{


    public GoblinArcher(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public boolean basicattack(Actor player) {
        System.out.println(this.name + " hugger med ett kortsvärd!");
        return super.basicAttack(player);
    }



    @Override
    public void rangedAttack(Player player) {
        System.out.println(this.name + " skjuter med en kortbåge!");
        player.takeDamage(this.damage);
    }
}
