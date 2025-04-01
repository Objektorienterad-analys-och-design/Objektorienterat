import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    List<Enemy> enemyList = new ArrayList<>();
    Player player;

    public Game() {
        enemyList.add(new Goblin("goblin 1", 50, 5));
        enemyList.add(new Goblin("goblin 2", 50,5));
        enemyList.add(new Orc("Orc 1", 100, 12) );
        enemyList.add(new Orc("Orc 2", 100,12));
        enemyList.add(new GoblinArcher("goblin archer 1", 50, 7));
        enemyList.add(new SkeletonArcher("Skelleton Archer 1", 80, 10));

        this.player = new Player("Bill",100, 10);
    }

    public void run(){

        Random rng = new Random();

        int randomNumber = rng.nextInt(enemyList.size());

        Enemy e = enemyList.get(randomNumber);

        System.out.println(player.name + " möter en " + e.name + "! Striden börjar!");
        System.out.println();
        combat(e);


    }

    public void combat(Enemy e){

        while(true){
            player.basicAttack(e);
            if(e.getHealth() <= 0){
                System.out.println(e.getName() + " dog");
                break;
            }
            e.basicattack(player);
            if(player.getHealth() <= 0){
                System.out.println(player.getName() + " dog");
                break;
            }

            System.out.println();
        }



    }
}
