package task_5_9;

import task_5_7.Equipment;
import task_5_7.Motorcyclist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Airline {
    ArrayList<CustomPlane> planes;

    public Airline() {planes = new ArrayList<>();}

    public void addPlane(CustomPlane plane){
        planes.add(plane);
    }

    public void removePlane(CustomPlane plane){
        planes.remove(plane);
    }

    public double capacitySum(){
        double sum = 0;
        for (CustomPlane eq :
                planes) {
            sum+=eq.getCapacity();
        }
        return sum;
    }

    public double weightSum(){
        double sum = 0;
        for (CustomPlane eq :
                planes) {
            sum+=eq.getWeight();
        }
        return sum;
    }

    public void flightRangeSort(){
        planes.sort(Comparator.comparingDouble(CustomPlane::getFlight_range));
    }

    public void fuelInRange(int a, int b){
        System.out.println("Plane with fuel consumption in range from a to b");
        for (CustomPlane plane:
                planes) {
            if (plane.getFuel() >=a && plane.getFuel()<=b){
                System.out.println(plane);
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Airline{" +
                "planes=" + planes +
                '}';
    }

    public static void main(String[] args){
        Airline airline = new Airline();
        airline.addPlane(new CustomPlane("small plane",30, 10, 1200,30));
        airline.addPlane(new Airliner(4500));
        airline.addPlane(new TransportPlane(300, 3200));
        airline.addPlane(new CustomPlane("big plane",300,280,5300, 170));
        System.out.println("Weight sum: " + airline.weightSum());
        System.out.println("Capacity sum: " + airline.capacitySum());
        airline.flightRangeSort();
        System.out.println("Sort by flight range: " + airline);
        System.out.println("Write a and b: ");
        Scanner in = new Scanner(System.in);
        int a,b;
        a = in.nextInt();
        b = in.nextInt();
        airline.fuelInRange(a,b);
    }
}
