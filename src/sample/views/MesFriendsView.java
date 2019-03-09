package sample.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sample.controllers.ControllerFriend;
import sample.controllers.ControllerRestaurant;
import sample.controllers.MesAmisController;
import sample.controllers.MesRestosController;
import sample.models.ModelFriend;
import sample.models.ModelListOfMyFriends;
import sample.models.ModelListOfMyRestaurants;
import sample.models.ModelRestaurant;

import java.io.IOException;

public class MesFriendsView {

    public static String XML_FILE = "sample/resources/fxml/myFriends.fxml";
    public static String CSS_FILE = "sample/resources/styles/mainStyle.css";
    public static final String LABEL = "booffinder";
    public static final int WIDTH = 720;
    public static final int HEIGHT = 480;

    private static ModelListOfMyFriends modelFriend;
    private static MesAmisController controller;

    private static int rangeSelectedItemFriend = -1;

    public static int getRangeSelectedItemFriend() {
        return rangeSelectedItemFriend;
    }

    public static void init(ModelListOfMyFriends modelFriend,  MesAmisController controller) {
        MesFriendsView.modelFriend = modelFriend;

        MesFriendsView.controller = controller;
        //init the ObservableList of custumers to the ListView

        controller.getMyFriendsListView().setItems(modelFriend.getListOfMyFriends());


        //call a cell factory and display each observable item in the ListView
        adaptItemsMyFriends( controller.getMyFriendsListView());
    }


    /**
     * display each item of the ListView
     * Automatically called if the ModelListCustomers.listOfCustumers is changed
     * @param listView the element to be filled
     */
    private static void adaptItemsMyFriends(ListView listView) {
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample/resources/fxml/friend.fxml"));
                                    //create the person controller
                                    ControllerFriend controller = new ControllerFriend();
                                    //attach the person controller to this person
                                    loader.setController(controller);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream("../resources/fxml/friend.fxml"));
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
