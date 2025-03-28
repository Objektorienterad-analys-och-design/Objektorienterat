
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Car c1 = new Car("Volvo","V90",2005);
//        Car c2 = new Car("Porche","newHotModel",2025);
//
//
//
//
//        Person p1 = new Person("Bill", 44);
//        Person p2 = new Person("Bosse", 23);
//        Person p3 = new Person("Arne", 55,c1);
//
//        c2.owner = p2;
//
//
////        p1.greet();
////        p2.greet();
//
//        p1.greet(p2);
//        p2.greet(p3);
//
//        p3.car = c2;
//        p1.greet(p3);
//
//       // p1.greet(p1);


        //eftersom både Programmer och Designer ärver från
        //Employee så kan vi lägga de i en lista med Employees
        List<Employee> employeeList = new ArrayList<>();


        Programmer programmerare = new Programmer("Bill",44,1,"Java");

        Designer designer = new Designer("Arne", 34,2, "Maya");

        Employee praktikanten = new Employee("Bosse",18,3);

        employeeList.add(designer);
        employeeList.add(programmerare);
        employeeList.add(praktikanten);


        for (Employee e : employeeList){
            e.greet();
        }


    }
}