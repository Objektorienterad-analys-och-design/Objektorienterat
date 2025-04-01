public  class CrytoAnimal extends Animal {

    public CrytoAnimal(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(this.name + " brölar!");
    }
}
