package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.ViewCustumer;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;


public class ControllerCostumer {
    private ModelListOfMyRestaurants modelListCustomers = null;
    private ViewCustumer view;
    @FXML
    private TextField nameField;
    @FXML
    private ListView cutomersListView;
    @FXML
    private Text choosenName;
    @FXML
    private Button addButton;
    @FXML
    private Button minusButton;
    @FXML
    private ImageView icon1;
    @FXML
    private ImageView icon2;



    public ListView getCutomersListView() {
        return cutomersListView;
    }

    public Text getChoosenName() {
        return choosenName;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void init(ModelListOfMyRestaurants customersList, ViewCustumer view) {
        this.modelListCustomers = customersList;
        //set image icon in the imageView
        icon1.setImage( new Image(ViewCustumer.IMG1));
        icon2.setImage( new Image(ViewCustumer.IMG2));


        //listner on the buttons
        addButton.setOnAction( event -> {
            modelListCustomers.add( new ModelRestaurant(nameField.getText()));
        });

        minusButton.setOnAction( event -> {
            modelListCustomers.getListOfMyRestaurants().remove( view.getRangeSelectedItem() );
        });

    }

}
