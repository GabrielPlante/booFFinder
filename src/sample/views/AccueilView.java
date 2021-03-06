package sample.views;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.util.Callback;
import sample.controllers.AccueilController;
import sample.controllers.ControllerRecommandation;
import sample.models.ModelListOfMyRecommandations;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;

import java.io.IOException;

public class AccueilView {

    public static String XML_FILE = "sample/resources/fxml/Accueil.fxml";
    public static String CSS_FILE = "sample/resources/styles/mainStyle.css";
    public static Image image = new Image("sample/resources/images/boofinder.png");
    public static final String LABEL = "booffinder";
    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;

    private static int rangeSelectedItem = -1;

    private static ModelListOfMyRecommandations modelRestaurant;
    private static AccueilController controller;

    public static void init( ModelListOfMyRecommandations model, AccueilController controller) {

        AccueilView.modelRestaurant = model;
        AccueilView.controller= controller;
        //init the ObservableList of custumers to the ListView
        controller.getMyRestaurantsListView().setItems(modelRestaurant.getListOfMyRestaurants());


        //call a cell factory and display each observable item in the ListView
        adaptItemsMyRestaurant( controller.getMyRestaurantsListView());
        listenTo(controller.getMyRestaurantsListView());
    }


    /**
     * display each item of the ListView
     * Automatically called if the ModelListCustomers.listOfCustumers is changed
     * @param listView the element to be filled
     */
    private static void adaptItemsMyRestaurant(ListView listView) {
        //Set a new cell factory to use in the ListView.
        listView.setCellFactory(
                //  first parameter specifies the type of the object passed in to the call method
                //  the second parameter specifying the return type of the method.
                new Callback<ListView, ListCell>() {
                    //define what to do when ModelListCustomers.listOfCustumers is changed
                    @Override
                    public ListCell call(ListView listView) {
                        return new ListCell() {
                            @Override
                            protected void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    Parent listElement=null;
                                    // Load fxml file for this Person
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample/resources/fxml/restaurant2.fxml"));
                                    //create the person controller
                                    ControllerRecommandation controller = new ControllerRecommandation();
                                    //attach the person controller to this person
                                    loader.setController(controller);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream("../resources/fxml/restaurant2.fxml"));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    controller.init((ModelRestaurant) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItemsMyRestaurant(listView);


                                }
                            }

                        };
                    }
                });
    }

    private static void listenTo(ListView listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ModelRestaurant>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = modelRestaurant.getListOfMyRestaurants().indexOf(newValue);
                    // --> GRRR! in javaFX the field Name is kbown in the Controller class (not in the view)
                });
    }

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }


}
