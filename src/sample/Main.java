package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.ControllerMenu;
import sample.models.ModelListOfMyFriends;
import sample.models.ModelListOfMyRestaurants;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();

        ViewMenu view = new ViewMenu();

        //create a controller
        ControllerMenu controller = new ControllerMenu();

        //attach controller
        loader.setController(controller);

        //attach XML file
        Parent root = loader.load(getClass().getResourceAsStream(view.XML_FILE));

        //attach css file
        root.getStylesheets().add(view.CSS);

        ModelListOfMyRestaurants modelRestaurant = new ModelListOfMyRestaurants();
        ModelListOfMyFriends modelFriend = new ModelListOfMyFriends();

        //initialize the controller
        controller.init( modelRestaurant,modelFriend, view );

        view.init( modelRestaurant, modelFriend,  controller );

        //create the view
        primaryStage.setScene(new Scene(root, view.WIDTH, view.HEIGHT));
        primaryStage.setTitle(view.LABEL);

        //show the view
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
