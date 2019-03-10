package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.controllers.LogginController;
import sample.models.ModelRegimeDataBase;
import sample.models.ModelRestaurantDataBase;
import sample.models.ModelUserDatabase;
import sample.views.LogginView;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{


        ModelRegimeDataBase modelRegimeDataBase = new ModelRegimeDataBase();
        ModelRestaurantDataBase modelRestaurantDataBase = new ModelRestaurantDataBase();
        ModelUserDatabase modelUserDatabase = new ModelUserDatabase(modelRestaurantDataBase,modelRegimeDataBase);

        FXMLLoader loader = new FXMLLoader();
        LogginController logginController = new LogginController(primaryStage);
        loader.setController(logginController);

        try{
            Parent root = loader.load(getClass().getResourceAsStream(LogginView.XML_FILE));
            root.getStylesheets().add(LogginView.CSS_FILE);
            primaryStage.setScene(new Scene(root, LogginView.WIDTH, LogginView.HEIGHT));
            logginController.init();
            primaryStage.setTitle(LogginView.LABEL);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("resources/images/boofinderico.png")));
            primaryStage.show();

        } catch (IOException E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
