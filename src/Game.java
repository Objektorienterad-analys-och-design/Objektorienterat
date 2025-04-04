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
        combat(player,e);

    }

    public void combat(Actor firstActor, Actor secondActor){

        Actor currentActor;
        if(Math.random() > 0.5){
            currentActor = firstActor;
        } else currentActor = secondActor;

        while(true){
            if(currentActor.equals(firstActor)){
                boolean targetIsAlive = firstActor.basicAttack(secondActor);
                if(!targetIsAlive){
                    break;
                }

            } else {
                boolean targetIsAlive = secondActor.basicAttack(firstActor);
                if(!targetIsAlive){
                    break;
                }
            }
            System.out.println();

            if (currentActor.equals(firstActor)){

                currentActor = secondActor;
            } else {
                currentActor = firstActor;

            }

        }

        System.out.println("combat over...");

    }
}
