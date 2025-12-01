package advancedConcepts.genericsCollections;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> idNamePair = new Pair<>();
        idNamePair.print(1, "Sandeep");

        Pair<Integer, Boolean> integerBooleanPair = new Pair<>();
        integerBooleanPair.print(10, true);

        Car car = new Car("FORD", "MUSTANG");
        Pair<Car, Double> carPricePair = new Pair<>();
        carPricePair.print(car, 11012.12);
    }
}
// break -> 10 mins -> 10:18 PM -> collections