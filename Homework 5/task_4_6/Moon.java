package task_4_6;

public class Moon {
    String name;

    public Moon(){this.name = "None";}
    public Moon(String name){this.name = name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Moon{" +
                "name='" + name + '\'' +
                '}';
    }
}
