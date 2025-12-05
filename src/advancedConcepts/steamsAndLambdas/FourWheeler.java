package advancedConcepts.steamsAndLambdas;

public class FourWheeler implements Vehicle {
    @Override
    public void start() {
        System.out.println("Starting FourWheeler");
    }

    @Override
    public void run() {
        System.out.println("Running FourWheeler");
    }

    @Override
    public void brake() {
        System.out.println("Braking FourWheeler");
    }
}
