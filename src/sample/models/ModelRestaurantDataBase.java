package sample.models;

import java.util.ArrayList;

public class ModelRestaurantDataBase {

    private static ArrayList<ModelRestaurant> restaurants;

    public ModelRestaurantDataBase() {

        restaurants= new ArrayList<>();

        ModelPlat pates = new ModelPlat("Pâtes",10,100);
        ModelPlat steak = new ModelPlat("Steak Frite",12,400);
        ModelPlat riz = new ModelPlat("Riz",11,100);
        ModelPlat hamburger = new ModelPlat("Hamburger",8,400);
        ModelPlat taccos = new ModelPlat("Taccos",8,450);
        ModelPlat nuggets = new ModelPlat("Nuggets",2,300);
        ModelPlat salade = new ModelPlat("Salade",5,10);
        ModelPlat sansgluten = new ModelPlat("Menu Sans gluten",8,100);
        ModelPlat happyMeal = new ModelPlat("Happy Meal", 3, 400);
        ModelPlat nem = new ModelPlat("Assiette de nems", 6, 200);

        ArrayList<ModelPlat> plats1 = new ArrayList<>();
        ArrayList<ModelPlat> plats2 = new ArrayList<>();
        ArrayList<ModelPlat> plats3 = new ArrayList<>();
        ArrayList<ModelPlat> plats4 = new ArrayList<>();
        ArrayList<ModelPlat> plats5 = new ArrayList<>();
        ArrayList<ModelPlat> plats6 = new ArrayList<>();
        ArrayList<ModelPlat> plats7 = new ArrayList<>();

        plats1.add(hamburger);
        plats1.add(nuggets);
        ModelListOfRegimes modelListOfRegimes1 = new ModelListOfRegimes();
        modelListOfRegimes1.add(ModelRegimeDataBase.getRegimes().get(0));
        modelListOfRegimes1.add(ModelRegimeDataBase.getRegimes().get(4));

        plats2.add(pates);
        plats2.add(riz);
        plats2.add(taccos);
        ModelListOfRegimes modelListOfRegimes2 = new ModelListOfRegimes();

        plats3.add(hamburger);
        plats3.add(steak);
        plats3.add(nuggets);
        ModelListOfRegimes modelListOfRegimes3 = new ModelListOfRegimes();
        modelListOfRegimes3.add(ModelRegimeDataBase.getRegimes().get(0));
        modelListOfRegimes3.add(ModelRegimeDataBase.getRegimes().get(4));

        plats4.add(riz);
        plats4.add(nem);
        plats4.add(pates);
        ModelListOfRegimes modelListOfRegimes4 = new ModelListOfRegimes();
        modelListOfRegimes4.add(ModelRegimeDataBase.getRegimes().get(3));

        plats5.add(hamburger);
        plats5.add(nuggets);
        plats5.add(happyMeal);
        ModelListOfRegimes modelListOfRegimes5 = new ModelListOfRegimes();
        modelListOfRegimes5.add(ModelRegimeDataBase.getRegimes().get(0));
        modelListOfRegimes5.add(ModelRegimeDataBase.getRegimes().get(4));

        plats6.add(salade);
        ModelListOfRegimes modelListOfRegimes6 = new ModelListOfRegimes();
        modelListOfRegimes6.add(ModelRegimeDataBase.getRegimes().get(2));


        plats7.add(sansgluten);
        ModelListOfRegimes modelListOfRegimes7 = new ModelListOfRegimes();
        modelListOfRegimes7.add(ModelRegimeDataBase.getRegimes().get(1));

        restaurants.add(new ModelRestaurant("Quick",4,plats1,"quick.jpg","Le poulet c'est bon",modelListOfRegimes1));
        restaurants.add(new ModelRestaurant("Bar",3,plats2,"","",modelListOfRegimes2));
        restaurants.add(new ModelRestaurant("KFC",2,plats3,"KFC.png","It's finger lickin' good",modelListOfRegimes3));
        restaurants.add(new ModelRestaurant("Restaurant chinois",5,plats4,"chinois.jpg","",modelListOfRegimes4));
        restaurants.add(new ModelRestaurant("Mac'Do",1,plats5,"macdo.png","Venez comme vous êtes",modelListOfRegimes5));
        restaurants.add(new ModelRestaurant("Restaurant Végétarien",4,plats6,"salade.jpg","Au menu : De l'herbe",modelListOfRegimes6));
        restaurants.add(new ModelRestaurant("Restaurant sans gluten",4,plats7,"sansGluten.jpg","Le gluten, c'est notre combat",modelListOfRegimes7));

    }

    public static ArrayList<ModelRestaurant> getRestaurants() {
        return restaurants;
    }
}
