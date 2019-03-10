package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.models.*;
import sample.views.AccueilView;
import sample.views.MesFriendsView;

import java.util.List;

public class ControllerMyFriendPage {

    @FXML
    private Button main_menu_accueil;

    @FXML
    private Button main_menu_mesRestos;

    @FXML
    private Button main_menu_mesAmis;

    @FXML
    private Button main_menu_mesRecommandations;

    @FXML
    private Button main_menu_parametres;
    @FXML
    private ImageView mainLogoImage;

    @FXML
    private Button retour;
    @FXML
    private Text nomAmis;
    @FXML
    private TableView tableRestaurants;
    @FXML
    private TableView tableRegimes;
    @FXML
    private Button main_menu_deco;

    private Stage stage;
    private User user;
    private PageLoader pg;
    private User friend;

    public ControllerMyFriendPage(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
        this.pg = new PageLoader(stage, user);

    }

    public void init(User amis) {

        this.friend = amis;
        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_mesRestos.setOnAction(event -> openMesRestos());
        main_menu_mesAmis.setOnAction(event -> openMesAmis());
        main_menu_parametres.setOnAction(event -> openParametres());
        main_menu_deco.setOnAction(event -> openLoggin());
        mainLogoImage.setImage(AccueilView.image);
        retour.setOnAction(event ->openMesAmis());


        nomAmis.setText(amis.getUsername());
        initTableRestaurants(amis);
        initRegimes(amis);

    }

    private void initTableRestaurants(User amis) {


        TableColumn nameColumn = new TableColumn("Nom");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        tableRestaurants.getColumns().addAll(nameColumn);

        nameColumn.prefWidthProperty().bind(tableRestaurants.widthProperty());

        for (ModelRestaurant modelRestaurant : amis.getMyRestaurants().getListOfMyRestaurants()) {
            tableRestaurants.getItems().add(modelRestaurant);
        }
    }

    private void initRegimes(User amis) {

        TableColumn nameColumn = new TableColumn("Nom");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableRegimes.getColumns().addAll(nameColumn);

        nameColumn.prefWidthProperty().bind(tableRegimes.widthProperty());

        for (ModelRegime modelRegime : amis.getMyRegimes().getRegimes()) {
            tableRegimes.getItems().add(modelRegime);
        }

    }

    private void openAccueil() {
        pg.openAccueil();
    }
    private void openMesRestos() {
        pg.openMesRestos();
    }
    private void openMesAmis() {
        pg.openMesAmis();
    }
    private void openParametres() {pg.openParametres();}
    private void openLoggin() {
        pg.openLoggin();
    }
}
