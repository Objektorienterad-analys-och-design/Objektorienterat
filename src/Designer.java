public class Designer extends Employee{



    protected String designTool;

    public Designer(String name, int age, int employerId, String designTool) {
        //en subklass måste anropa en specifik konstruktor i sin superklass
        // OM det inte finns en default Konrtuktor i superklasssen
        super(name,age,employerId);
        this.designTool = designTool;
    }

    @Override
    public void greet() {

        System.out.println("jag är en designer och heter " + this.name +"!");

    }

    @Override
    public String toString() {
        return "Designer{" +
                "designTool='" + designTool + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", employerId=" + employerId +
                '}';
    }
}
