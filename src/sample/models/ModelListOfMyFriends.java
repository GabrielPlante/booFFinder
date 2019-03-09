package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelListOfMyFriends {

    private ObservableList<ModelPerson> listOfMyFriends;

    public ModelListOfMyFriends() {
        listOfMyFriends = FXCollections.observableList(new ArrayList<>());
        ArrayList<ModelRestaurant> restaurants1 = new ArrayList<>();
        ArrayList<ModelRestaurant> restaurants2 = new ArrayList<>();
        restaurants1.add(new ModelRestaurant("Bar",3,new ArrayList<>(),"",""));
        restaurants2.add(new ModelRestaurant("KFLand",2,new ArrayList<>(),"",""));
        restaurants1.add(new ModelRestaurant("Restaurant chinois",5,new ArrayList<>(),"",""));
        restaurants2.add(new ModelRestaurant("Le monde des délices",1,new ArrayList<>(),"",""));

        ArrayList<ModelRegime> regimes1 = new ArrayList<>();
        ArrayList<ModelRegime> regimes2 = new ArrayList<>();
        regimes1.add(new ModelRegime("Végétarien"));
        regimes1.add(new ModelRegime("Sans gluten"));

        regimes2.add(new ModelRegime("Gourmand"));

        listOfMyFriends.add(new ModelPerson("Maxime09000",restaurants1,regimes1));
        listOfMyFriends.add(new ModelPerson("LeKingofTheNorth",restaurants2, regimes2));


    }

    public void add(ModelPerson friend) {
        listOfMyFriends.add(friend);
    }

    public ObservableList<ModelPerson> getListOfMyFriends() {
        return listOfMyFriends;
    }

}
