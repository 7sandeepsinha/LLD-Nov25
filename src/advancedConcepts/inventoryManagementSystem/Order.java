package advancedConcepts.inventoryManagementSystem;

public class Order implements Comparable<Order> {
    private String orderId;
    private String itemId;
    private int quantity;
    private boolean isExpress;

    public Order(String orderId, String itemId, int quantity, boolean isExpress) {
        //add validation for orderId
        //auto generate orderId
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.isExpress = isExpress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }


    @Override
    public int compareTo(Order order) {
        if(this.isExpress == order.isExpress) { // either both express or both normal
            return this.orderId.compareTo(order.orderId); // return basis on shortest order ID
        } else if(this.isExpress == true) {
            return -1;
        } else {
            return 1;
        }
    }
}
/*
a.compareTo(b)
-1 --> a
1 --> b
0 --> equal

O1 -> id =1 , express = true
O2 -> id = 2, express = true
O3 -> id = 3, express = false

o1.compareTo(o2) --> logical = o1
o1.compareTo(o3) --> o1
 */