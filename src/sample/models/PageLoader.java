package sample.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.*;
import sample.views.*;

import java.io.IOException;

public class PageLoader {

    private Stage stage;

    private User user;

    public PageLoader(Stage stage, User user) {
        this.stage = stage;
        this.user = user;
    }

    public void openAccueil() {
        FXMLLoader loader = new FXMLLoader();
        AccueilController controller = new AccueilController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            ModelListOfMyRecommandations modelRecommandations = user.getMyRecommandations();
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/Accueil.fxml"));
            root.getStylesheets().add(AccueilView.CSS_FILE);
            //initialize the controller
            controller.init(modelRecommandations);
            AccueilView.init(modelRecommandations,controller);
            //create the view
            this.stage.setScene(new Scene(root, AccueilView.WIDTH, AccueilView.HEIGHT));
            this.stage.setTitle(AccueilView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public void openParametres() {
        FXMLLoader loader = new FXMLLoader();
        ParametresController controller = new ParametresController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/Parametres.fxml"));
            root.getStylesheets().add(ParametresView.CSS_FILE);
            //initialize the controller
            controller.init();
            //create the view
            this.stage.setScene(new Scene(root, ParametresView.WIDTH, ParametresView.HEIGHT));
            this.stage.setTitle(ParametresView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public void openMesAmis() {
        FXMLLoader loader = new FXMLLoader();
        MesAmisController controller = new MesAmisController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {
            ModelListOfMyFriends modelListOfMyFriends = user.getMyFriends();
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/myFriends.fxml"));
            root.getStylesheets().add(MesFriendsView.CSS_FILE);
            //initialize the controller
            controller.init(modelListOfMyFriends);
            MesFriendsView.init(modelListOfMyFriends,controller);
            //create the view
            this.stage.setScene(new Scene(root, MesFriendsView.WIDTH, MesFriendsView.HEIGHT));
            this.stage.setTitle(MesFriendsView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }
    }

    public void openMesRestos() {
        FXMLLoader loader = new FXMLLoader();
        MesRestosController controller = new MesRestosController(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {

            ModelListOfMyRestaurants modelRestaurant = user.getMyRestaurants();

            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/MesRestos.fxml"));
            root.getStylesheets().add(MesRestosView.CSS_FILE);
            //initialize the controller

            controller.init(modelRestaurant);
            MesRestosView.init(modelRestaurant,controller);

            //create the view
            this.stage.setScene(new Scene(root, MesRestosView.WIDTH, MesRestosView.HEIGHT));
            this.stage.setTitle(MesRestosView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }

    }

    public void openMesRestosPage(ModelRestaurant restaurant,String lastPage) {
        FXMLLoader loader = new FXMLLoader();
        ControllerMyRestoPage controller = new ControllerMyRestoPage(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {


            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/MesRestosPage.fxml"));
            root.getStylesheets().add(MesRestosView.CSS_FILE);
            //initialize the controller

            controller.init(restaurant,lastPage);

            //create the view
            this.stage.setScene(new Scene(root, MesRestosView.WIDTH, MesRestosView.HEIGHT));
            this.stage.setTitle(MesRestosView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }

    }

    public void openMesAmisPage(User person) {
        FXMLLoader loader = new FXMLLoader();
        ControllerMyFriendPage controller = new ControllerMyFriendPage(this.stage, this.user);

        //attach controller
        loader.setController(controller);

        try {


            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/FriendPage.fxml"));
            root.getStylesheets().add(MesRestosView.CSS_FILE);
            //initialize the controller

            controller.init(person);

            //create the view
            this.stage.setScene(new Scene(root, MesFriendsView.WIDTH, MesFriendsView.HEIGHT));
            this.stage.setTitle(MesFriendsView.LABEL);

            //show the view
            this.stage.show();
        } catch (IOException E) {
            E.printStackTrace();
        }

    }

    public void openLoggin() {
        FXMLLoader loader = new FXMLLoader();
        LogginController logginController = new LogginController(this.stage);
        loader.setController(logginController);

        try{
            Parent root = loader.load(getClass().getResourceAsStream("/sample/resources/fxml/Loggin.fxml"));
            root.getStylesheets().add(LogginView.CSS_FILE);
            this.stage.setScene(new Scene(root, LogginView.WIDTH, LogginView.HEIGHT));
            logginController.init();
            this.stage.setTitle(LogginView.LABEL);
            this.stage.show();

        } catch (IOException E){
            E.printStackTrace();
        }

    }


}
