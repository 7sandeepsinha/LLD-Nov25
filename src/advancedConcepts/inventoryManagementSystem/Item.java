package advancedConcepts.inventoryManagementSystem;

public abstract class Item implements Comparable<Item> {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Item() {
    }

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Item item) {
        if(this.price < item.getPrice()) {
            return -1; // calling object has lesser price than comparing object[item]
        } else if(this.price > item.getPrice()) {
            return 1; // calling object has greater price than comparing object[item]
        } else {
            return 0; // equal
        }
    }
}
/**
 *  Item i1 = new Item();
 *  Item i2 = new Item();
 *
 *  i1.compareTo(i2);
 *  this = i1
 *  item = i2
 */
