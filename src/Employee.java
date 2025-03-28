public class Employee extends Person {

    protected int employerId;


    public Employee() {
        super();
    }

    public Employee(String name, int age, int employerId) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.employerId = employerId;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", employerId=" + employerId +
                '}';
    }
}
