package oops;

public class Car {
    int id;
    String model;
    String color;

    public Car(){
        System.out.println("Executing Car constructor");
    }

    public void unlockCar(){
        System.out.println("Unlocking Car");
    }

    private void changeEngineOil(){
        System.out.println("Changing Engine Oil");
    }
}
