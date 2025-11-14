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

    public void changeEngineOil(){
        System.out.println("Changing Engine Oil");
    }

    public void startEngine(){
        System.out.println("Engine starting in basic Car");
    }
}
