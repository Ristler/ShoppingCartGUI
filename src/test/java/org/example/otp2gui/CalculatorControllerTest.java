package org.example.otp2gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {
    CalculatorController controller;
    ShoppingCart shoppingCart;
    Item item1;
    Item item2;


    @BeforeEach
    void setUp() {
        controller = new CalculatorController();
        shoppingCart = new ShoppingCart();
        item1 = new Item(1, 10);
        item2 = new Item(1, 10);
    }


    @Test
    void calculate() {
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        assertEquals(20, controller.calculate(shoppingCart));
    }
}
