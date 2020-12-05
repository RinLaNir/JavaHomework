package task_19;

import java.util.*;

class Car implements Comparable<Car>{
    int number;
    int speed;
    int place;
    public Car(int number, int speed, int place){
        this.number = number;
        this.place = place;
        this.speed = speed;
    }

    public int getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.getPlace(), o.getPlace());
    }
}

public class Hm {
    public static void rotate(List<Car> aL, int shift)
    {
        if (aL.size() == 0)
            return;

        Car element = null;
        for(int i = 0; i < shift; i++)
        {
            element = aL.remove( aL.size() - 1 );
            aL.add(0, (Car) element);
        }

    }

    public static void main(String[] args) {
        final int[] k = {0};
        LinkedHashSet<String> set = new LinkedHashSet<>();

        class CustomComparator implements Comparator<Car>{

            @Override
            public int compare(Car o1, Car o2) {
                if (o1.compareTo(o2) < 0){
                    set.add(o1.number + " обігнав " + o2.number);
                    return o1.compareTo(o2);
                }
                return o1.compareTo(o2);
            }
        }

        List<Car> cars = new ArrayList<Car>(){
            {
                add(new Car(1,1,100));
                add(new Car(2,3,70));
                add(new Car(3,7,20));
                add(new Car(4,10,0));
                add(new Car(5,2,40));
                add(new Car(6,5,60));
                add(new Car(7,3,30));
                add(new Car(8,8,35));
                add(new Car(9,5,15));
                add(new Car(10,4,90));
            }
        };
        int max_len = 1000;
        int K = 8,N = 10;

        cars.sort(Comparator.comparingInt(Car::getPlace));

        while (set.size() <K){
            for (Car car :
                    cars) {
                car.place+= car.speed;
                if (car.place >= max_len){
                    car.place%=max_len;
                    rotate(cars,1);
                }
            }
            cars.sort(new CustomComparator());
        }
        System.out.println(set);
    }
}