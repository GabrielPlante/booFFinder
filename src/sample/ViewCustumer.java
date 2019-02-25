package sample;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.controllers.ControllerCostumer;
import sample.controllers.ControllerRestaurant;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;

import java.io.IOException;


public class ViewCustumer {
    static final String XML_FILE = "resources/settings.fxml";
    static final String CSS = "sample/resources/settings.css";
    static final String LABEL = "HFV";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static final String PERSON = "resources/restaurant.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfMyRestaurants model;
    private static ControllerCostumer controller;

    /**
     * getter
     * @return
     */
    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }


    void init(ModelListOfMyRestaurants model, ControllerCostumer controller) {
        ViewCustumer.model = model;
        ViewCustumer.controller = controller;
        //init the ObservableList of custumers to the ListView
        controller.getCutomersListView().setItems(model.getListOfMyRestaurants());

        //call a cell factory and display each observable item in the ListView
        adaptItems( controller.getCutomersListView() );

        //listner if user click in the ListView update rangeSelectedItem value

    }


    /**
     * display each item of the ListView
     * Automatically called if the ModelListCustomers.listOfCustumers is changed
     * @param listView the element to be filled
     */
    private void adaptItems(ListView listView) {
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(PERSON));
                                    //create the person controller
                                    ControllerRestaurant personController = new ControllerRestaurant();
                                    //attach the person controller to this person
                                    loader.setController(personController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(PERSON));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    personController.init((ModelRestaurant) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                    //remove TextField name contents
                                }
                            }

                        };
                    }
                });
    }


}
