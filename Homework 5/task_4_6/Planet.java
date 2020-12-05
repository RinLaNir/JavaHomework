package task_4_6;

public class Planet {
    private String name;
    private Moon moon;

    Planet(){
        this.moon = new Moon();
        this.name = "None";
    }
    Planet(String name){
        this.moon = new Moon();
        this.name = name;
    }
    Planet(String name, String name2){
        this.moon = new Moon(name2);
        this.name = "None";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    public String getName() {
        return name;
    }

    public Moon getMoon() {
        return moon;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", moon=" + moon +
                '}';
    }
}
