package task_5_7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Motorcyclist {
    ArrayList<Equipment> equipments;

    Motorcyclist(){
        equipments = new ArrayList<>();
    }

    void addEquipment(Equipment eq){
        equipments.add(eq);
    }

    void removeEquipment(Equipment eq){
        equipments.remove(eq);
    }

    double sumPrice(){
        double sum=0;
        for (Equipment eq :
                equipments) {
            sum += eq.getPrice();
        }
        return sum;
    }

    void sort(){
        equipments.sort(Comparator.comparingDouble(Equipment::getWeight));
    }

    void inRange(double a, double b){
        System.out.println("Equipment with price from " + a + " to " + b);
        for (Equipment eq :
                equipments) {
            if (eq.getPrice() >= a && eq.getPrice() <= b)
                System.out.println(eq);
        }
    }

    @Override
    public String toString() {
        return equipments.toString();
    }

    public static void main(String[] args) {
        Motorcyclist motorcyclist = new Motorcyclist();
        motorcyclist.addEquipment(new Equipment("Pants", 2000, 1.2f));
        motorcyclist.addEquipment(new Equipment("Gloves", 800, 0.7f));
        motorcyclist.addEquipment(new Equipment("Helmet", 1500, 1.7f));
        motorcyclist.addEquipment(new Equipment("Jacket", 4000, 1.5f));

        System.out.println("Price sum: " + motorcyclist.sumPrice());
        motorcyclist.sort();
        System.out.println("Sort by weight: " + motorcyclist);
        Scanner in = new Scanner(System.in);
        double a,b;
        System.out.print("Enter a and b: ");
        a = in.nextDouble();
        b = in.nextDouble();
        motorcyclist.inRange(a,b);
    }
}
