package task_4_6;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private Star star;

    private final List<Planet> planetList = new ArrayList<>();

    public StarSystem(Star name) {
        this.star = name;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Star getStar() {
        return star;
    }

    public void addPlanet(Planet planet) {
        planetList.add(planet);
    }

    public int numPlanets(){
        return planetList.size();
    }

    @Override
    public String toString() {
        return "System{" +
                "star=" + star +
                ", planetList=" + planetList +
                '}';
    }

    public static void main(String[] args){
        StarSystem system = new StarSystem(new Star("Star system"));
        system.addPlanet(new Planet("Planet 1"));
        system.addPlanet(new Planet("Planet 2", "Moon 21"));
        system.addPlanet(new Planet("Planet 3"));
        system.addPlanet(new Planet("Planet 4"));
        system.addPlanet(new Planet("Planet 5"));

        System.out.println("Number of planets: " + system.numPlanets());
        System.out.println("Name of system star: " + system.getStar());
    }
}