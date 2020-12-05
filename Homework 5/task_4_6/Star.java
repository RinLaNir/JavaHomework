package task_4_6;

public class Star {
    String name;

    public Star(String name){this.name = name;}
    public Star(){this.name = "None";}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
