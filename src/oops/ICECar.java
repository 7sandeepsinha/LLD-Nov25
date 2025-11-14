package oops;

public class ICECar extends Car { // ICECar is child of Car
    int engineSize; // 4 attributes -> 3 parent + 1 own

    public ICECar(){
        System.out.println("Executing ICECar constructor");
    }

    public void refuelCar(){
        System.out.println("Refueling Car");
    }
}
