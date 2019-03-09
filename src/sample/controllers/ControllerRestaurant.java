package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.ModelRestaurant;

public class ControllerRestaurant {

    @FXML
    private Label nameRestaurant;

    public void init(ModelRestaurant restaurant) {
        nameRestaurant.setText(restaurant.getName());
    }



}
