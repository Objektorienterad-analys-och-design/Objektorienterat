public class Bird extends Animal implements Flyable{
    public Bird(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(this.name + " kvittrar");
    }

    @Override
    public void fly() {
        System.out.println(this.name +  "flyger!!!");
    }
}
