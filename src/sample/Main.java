package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.controllers.ControllerCostumer;
import sample.models.ModelListOfMyRestaurants;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();

        ViewCustumer view = new ViewCustumer();

        //create a controller
        ControllerCostumer controller = new ControllerCostumer();

        //attach controller
        loader.setController(controller);

        //attach XML file
        Parent root = loader.load(getClass().getResourceAsStream(view.XML_FILE));

        //attach css file
        root.getStylesheets().add(view.CSS);

        ModelListOfMyRestaurants model = new ModelListOfMyRestaurants();

        //initialize the controller
        controller.init( model, view );

        view.init( model, controller );

        //create the view
        primaryStage.setScene(new Scene(root, view.WIDTH, view.HEIGHT));
        primaryStage.setTitle(view.LABEL);


        primaryStage.getIcons().add(new Image("sample/resources/icon.png"));

        //show the view
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
