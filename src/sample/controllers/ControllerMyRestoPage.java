package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.models.*;
import sample.views.AccueilView;

public class ControllerMyRestoPage {

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
    private Text nomRestaurant;
    @FXML
    private Text note;
    @FXML
    private TableView tablePlats;

    @FXML
    private Circle restaurantImage;
    @FXML
    private Button ajouterRestaurant;
    @FXML
    private Button main_menu_deco;
    @FXML
    private Text adresse;

    private Stage stage;
    private User user;
    private PageLoader pg;
    private ModelRestaurant modelRestaurant;
    private String lastPage;

    public ControllerMyRestoPage(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
        this.pg = new PageLoader(stage, user);

    }

    public void init(ModelRestaurant restaurant, String lastPage) {
        this.lastPage = lastPage;

        this.modelRestaurant = restaurant;
        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_mesRestos.setOnAction(event -> openMesRestos());
        main_menu_mesAmis.setOnAction(event -> openMesAmis());
        main_menu_parametres.setOnAction(event -> openParametres());
        main_menu_deco.setOnAction(event -> openLoggin());
        adresse.setText(restaurant.getAdresse());
        mainLogoImage.setImage(AccueilView.image);
        retour.setOnAction(event ->retourBouton());

        restaurantImage.setFill(new ImagePattern(new Image(restaurant.getUrl())));
        nomRestaurant.setText(restaurant.getName());
        note.setText(String.valueOf(restaurant.getNote()));
        initTablePlats();

        updateState(restaurant);

    }

    private void retourBouton() {
        if (lastPage.equals("accueil")) pg.openAccueil();
        else if (lastPage.equals("mesRestos")) pg.openMesRestos();
    }

    private void updateState(ModelRestaurant restaurant) {
        if(user.getMyRestaurants().getListOfMyRestaurants().contains(restaurant)) {
            ajouterRestaurant.setText("Supprimer");
            ajouterRestaurant.setOnAction(event -> supprimerRest());

        }
        else {
            ajouterRestaurant.setText("Ajouter");
            ajouterRestaurant.setOnAction(event -> ajouterRest());
        }
    }

    private void ajouterRest() {
        user.getMyRestaurants().add(modelRestaurant);
        user.updateRecommandations();
        pg.openMesRestosPage(modelRestaurant,lastPage);
    }

    private void supprimerRest() {
        user.getMyRestaurants().remove(modelRestaurant);
        user.updateRecommandations();
        pg.openMesRestosPage(modelRestaurant,lastPage);
    }

    private void initTablePlats() {


        TableColumn nameColumn = new TableColumn("Plat");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn priceColumn = new TableColumn("Prix");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));

        TableColumn caloriesColumn = new TableColumn("Calories");
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));

        tablePlats.getColumns().addAll(nameColumn,priceColumn,caloriesColumn);

        nameColumn.prefWidthProperty().bind(tablePlats.widthProperty().divide(2));
        priceColumn.prefWidthProperty().bind(tablePlats.widthProperty().divide(4));
        caloriesColumn.prefWidthProperty().bind(tablePlats.widthProperty().divide(4));
        for (ModelPlat modelPlat : modelRestaurant.getPlats()) {
            tablePlats.getItems().add(modelPlat);
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
