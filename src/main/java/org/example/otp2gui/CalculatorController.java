package org.example.otp2gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Locale;
import java.util.ResourceBundle;

public class CalculatorController {

    @FXML private Menu changeLangText;
    @FXML private Button sendButton;
    @FXML private TextField userInput;
    @FXML private TextField amountOfItemField;
    @FXML private TextField priceForItemField;
    @FXML private Label itemsToAddLabel;
    @FXML private Label totalSumLabel;
    @FXML private TextField quantityOfItems;
    @FXML private Button setQuantityOfItemsButton;

    int numberOfItems;
    int totalSum = 0;
    int price;
    int amount;

    ShoppingCart cart = new ShoppingCart();

    private ResourceBundle resourceBundle;

    @FXML
    public void initialize() {
        sendButton.setVisible(false);

        priceForItemField.setVisible(false);
        amountOfItemField.setVisible(false);
        System.out.println("Initializing Controller...");
            loadLanguage("en", "US"); // Default language
    }


    private void loadLanguage(String langCode, String country) {

        Locale locale = new Locale(langCode, country);
        resourceBundle = ResourceBundle.getBundle("MessagesBundle", locale);
        changeLangText.setText(resourceBundle.getString("changeLangText"));
        sendButton.setText(resourceBundle.getString("proceedButton"));
        quantityOfItems.setPromptText(resourceBundle.getString("numberOfItems"));
        priceForItemField.setPromptText(resourceBundle.getString("priceForItem"));
        amountOfItemField.setPromptText(resourceBundle.getString("quantityOfItem"));
        itemsToAddLabel.setText(resourceBundle.getString("toAdd") + " " + numberOfItems);
        totalSumLabel.setText(resourceBundle.getString("totalCost") + " " + totalSum);

    }

    @FXML
    protected void onEnglishButtonClick() {
        loadLanguage("en", "US"); // English
    }

    @FXML
    protected void onFinnishButtonClick() {
        loadLanguage("fi", "FI"); // Finnish
    }

    @FXML
    protected void onSwedishButtonClick() {
        loadLanguage("sv", "SE"); // Swedish
    }
    @FXML
    protected void onJapaneseButtonClick() {
        loadLanguage("ja", "JP"); // Swedish
    }


    public void onSendButtonClick(ActionEvent actionEvent) {


        if(numberOfItems != 0) {
            price = Integer.parseInt(priceForItemField.getText());
            amount = Integer.parseInt(amountOfItemField.getText());

            Item item = new Item(price, amount);
            System.out.println("Item added! " + item.getPrice());
            numberOfItems--;
            itemsToAddLabel.setText(resourceBundle.getString("toAdd")+ " " + numberOfItems);

            cart.addItem(item);

            priceForItemField.setText("");
            amountOfItemField.setText("");

            if (numberOfItems == 0) {
                System.out.println("Cant add anymore items! its full");
                totalSumLabel.setText(resourceBundle.getString("totalCost") + " " + calculate(cart));

            }
        }
    }

    public void onQuantitySet(ActionEvent actionEvent) {
        numberOfItems = Integer.parseInt(quantityOfItems.getText());

        if(numberOfItems > 0) {
            itemsToAddLabel.setText(resourceBundle.getString("toAdd")+ " " + numberOfItems);
            quantityOfItems.setVisible(false);
            priceForItemField.setVisible(true);
            amountOfItemField.setVisible(true);
            setQuantityOfItemsButton.setVisible(false);
            sendButton.setVisible(true);
        }
    }
    public int calculate(ShoppingCart cart) {
        for(Item item : cart.getShoppingCart()) {
            totalSum += item.getPrice() * item.getQuantity();
        }
        System.out.println("total cost: "+ totalSum);
        return totalSum;
    }
}