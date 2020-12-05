package task_5_9;

class CustomPlane {
    String name;
    int capacity;
    int weight;
    int flight_range;
    int fuel;

    CustomPlane(String name, int capacity, int weight, int flight_range, int fuel){
        this.name = name;
        this.capacity = capacity;
        this.weight = weight;
        this.flight_range = flight_range;
        this.fuel = fuel;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFlight_range(int flight_range) {
        this.flight_range = flight_range;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFlight_range() {
        return flight_range;
    }

    public int getWeight() {
        return weight;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "CustomPlane{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", weight=" + weight +
                ", flight_range=" + flight_range +
                ", fuel=" + fuel +
                '}';
    }
}
