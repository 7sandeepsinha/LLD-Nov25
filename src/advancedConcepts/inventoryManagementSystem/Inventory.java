package advancedConcepts.inventoryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T extends Item> {
    private HashMap<String, T> items; // hashmap > key: String, value: T

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void add(T item) {
        //validate - id is not duplicate
        //validate - id is not null or empty
        //validate - item object is not null
        items.put(item.getId(), item);
    }

    public T get(String id) {
        //no need for validations
        // throw exception if item not found
        return items.get(id);
    }

    public void remove(String id) {
        //no need for validations
        // throw exception if item not found
        items.remove(id);
    }

    public List<T> getAll(){
        //no need for validations
        // return empty arrayList if item not found
        return new ArrayList<>(items.values());
    }
}
/*

        Inventory<Book> books = new Inventory<>();
        hashmap<String,Book>

        Inventory<Clothes> books = new Inventory<>();
        hashmap<String,Clothes>

        Inventory<Electronics> books = new Inventory<>();

        Inventory<Car> cars = new Inventory<>();
        Inventory<Integer> ints = new Inventory<>();
 */