package org.example.otp2gui;

import java.util.ArrayList;

public class ShoppingCart {

    ArrayList<Item> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }
    public ArrayList<Item> getShoppingCart() {
        return cart;
    }
    public void addItem(Item item) {
        cart.add(item);
    }
}