import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Animal hund = new Dog("Bosse");
        Animal katt = new Cat("Morran");

        Animal randomDjur = new CrytoAnimal("Bigfoot");

        Bird fågel = new Bird("skatan");

        hund.makeSound();
        katt.makeSound();
        randomDjur.makeSound();

        fågel.makeSound();

        fågel.fly();

    }
}