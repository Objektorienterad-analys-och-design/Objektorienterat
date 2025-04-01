import java.util.Random;

public class SkeletonArcher extends Enemy implements RangedUnit{


    public SkeletonArcher(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void basicattack(Player player) {
        System.out.println(this.name + " hugger med ett svärd!");
        player.takeDamage(this.damage);
    }

    @Override
    public void rangedAttack(Player player) {
        System.out.println(this.name + " skjuter med en långbåge!");
        player.takeDamage(this.damage);
    }

//    @Override
//    public void regenerateHealth() {
//        System.out.println(this.name + " återfick 5 hälsopoäng fråm sin regenerering!");
//    }
}
