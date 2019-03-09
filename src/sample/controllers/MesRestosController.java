package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.models.ModelListOfMyRestaurants;
import sample.models.PageLoader;
import sample.models.User;
import sample.views.AccueilView;

public class MesRestosController {

    private ModelListOfMyRestaurants modelListOfMyRestaurants = null;

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
    private ListView myRestaurantsListView;

    @FXML
    private Button allerSurLaPage;
    @FXML
    private ImageView mainLogoImage;

    private Stage stage;
    private User user;
    private PageLoader pg;

    public MesRestosController(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
        this.pg = new PageLoader(stage, user);

    }

    public void init(ModelListOfMyRestaurants myRestaurantsList) {

        this.modelListOfMyRestaurants = myRestaurantsList;
        main_menu_accueil.setOnAction(event -> openAccueil());
        main_menu_mesRestos.setOnAction(event -> openMesRestos());
        main_menu_mesAmis.setOnAction(event -> openMesAmis());
        main_menu_mesRecommandations.setOnAction(event -> openMesRecommandations());
        main_menu_parametres.setOnAction(event -> openParametres());
        mainLogoImage.setImage(AccueilView.image);
        allerSurLaPage.setOnAction(event -> openMesRestosPage());

    }

    public ListView getMyRestaurantsListView() {
        return myRestaurantsListView;
    }


    private void openMesRestosPage() {
        pg.openMesRestosPage();
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
    private void openMesRecommandations() {pg.openMesRecommandations();}
    private void openParametres() {pg.openParametres();}


}
