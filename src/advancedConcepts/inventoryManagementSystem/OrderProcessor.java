package advancedConcepts.inventoryManagementSystem;

import java.util.PriorityQueue;
import java.util.Queue;

public class OrderProcessor {
    private Queue<Order> orders;

    public OrderProcessor() {
        this.orders = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public Order getNextOrder() {
        return this.orders.poll();
    }
}
