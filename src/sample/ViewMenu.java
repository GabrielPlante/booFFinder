package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.controllers.ControllerFriend;
import sample.controllers.ControllerMenu;
import sample.controllers.ControllerRestaurant;
import sample.models.ModelFriend;
import sample.models.ModelListOfMyFriends;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;

import java.io.IOException;


public class ViewMenu {
    static final String XML_FILE = "resources/settings.fxml";
    static final String CSS = "sample/resources/settings.css";
    static final String LABEL = "HFV";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static final String RESTAURANT = "resources/restaurant.fxml";
    private static final String FRIEND = "resources/friend.fxml";

    private static ModelListOfMyRestaurants modelRestaurant;
    private static ModelListOfMyFriends modelFriend;

    private static ControllerMenu controller;



    void init(ModelListOfMyRestaurants modelRestaurant, ModelListOfMyFriends modelFriend, ControllerMenu controller) {
        ViewMenu.modelRestaurant = modelRestaurant;
        ViewMenu.modelFriend = modelFriend;

        ViewMenu.controller = controller;
        //init the ObservableList of custumers to the ListView

        controller.getMyRestaurantsListView().setItems(modelRestaurant.getListOfMyRestaurants());
        controller.getMyFriendsListView().setItems(modelFriend.getListOfMyFriends());

        //call a cell factory and display each observable item in the ListView
        adaptItemsMyRestaurant( controller.getMyRestaurantsListView());
        adaptItemsMyFriends(controller.getMyFriendsListView());


    }


    /**
     * display each item of the ListView
     * Automatically called if the ModelListCustomers.listOfCustumers is changed
     * @param listView the element to be filled
     */
    private void adaptItemsMyRestaurant(ListView listView) {
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(RESTAURANT));
                                    //create the person controller
                                    ControllerRestaurant controller = new ControllerRestaurant();
                                    //attach the person controller to this person
                                    loader.setController(controller);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(RESTAURANT));
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

    private void adaptItemsMyFriends(ListView listView) {
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(FRIEND));
                                    //create the person controller
                                    ControllerFriend controller = new ControllerFriend();
                                    //attach the person controller to this person
                                    loader.setController(controller);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(FRIEND));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    controller.init((ModelFriend) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItemsMyFriends(listView);


                                }
                            }

                        };
                    }
                });
    }




}
