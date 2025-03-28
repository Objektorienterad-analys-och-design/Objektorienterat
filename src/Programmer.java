public class Programmer extends Employee {


    protected String programmingLanguage;


    public Programmer(String name, int age, int employerId, String programmingLanguage) {
        //en subklass behöver INTE anropa en specifik konstruktor i sin superklass
        // OM det finns en default Konstuktor i superklasssen
        this.name = name;
        this.age = age;
        this.employerId = employerId;
        this.programmingLanguage = programmingLanguage;

    }

    @Override
    public String toString() {
        return "Programmer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", employerId=" + employerId +
                '}';
    }
}
