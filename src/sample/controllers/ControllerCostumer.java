package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.ViewCustumer;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;


public class ControllerCostumer {
    private ModelListOfMyRestaurants modelListCustomers = null;

    private ViewCustumer view;

    @FXML
    private ListView cutomersListView;
    @FXML
    private Text choosenName;
    @FXML
    private Button minusButton;


    public ListView getCutomersListView() {
        return cutomersListView;
    }

    public Text getChoosenName() {
        return choosenName;
    }


    public void init(ModelListOfMyRestaurants customersList, ViewCustumer view) {
        this.modelListCustomers = customersList;



    }

}
