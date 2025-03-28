public class Person {

    //protected = som public för subklasser och inom samma package
    protected String name;
    protected int age;

    protected Car car;

    public Person() {
    }

    public Person(String name, int age){
        this.name=name;
        this.age=age;

    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public void greet(){
        System.out.println("hej, jag heter " + this.name);
    }
    //overloading = samma metodnamn, men olika argument
    public void greet(Person otherGuy){

        if(otherGuy.equals(this)){
            System.out.println(this.name +": Hej min spegelbild!");
        } else {
            System.out.println(this.name + ": Hej, " + otherGuy.name +"!");
        }
        if (otherGuy.car != null && otherGuy.car.owner != null){
//            System.out.println("vilken fin " + otherGuy.car.make
//                    + " " + otherGuy.car.model + " du har! vilket år är den ifrån?");
            System.out.println(otherGuy.name + " är inte det där " + otherGuy.car.owner.name + "'s bil?");
        }




    }


}
