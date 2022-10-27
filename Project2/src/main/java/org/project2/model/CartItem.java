package org.project2.model;

public class CartItem extends Pack{
    int quantity;

    public CartItem(int quantity) {
        this.quantity = quantity;
    }

    public CartItem(int packId, String setName, int quantity) {
        super(packId, setName);
        this.quantity = quantity;
    }

    public CartItem(int packId, String setName) {
        super(packId, setName);
        this.quantity = 1;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity + ',' +super.toString() +
                '}';
    }

    public CartItem() {}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
