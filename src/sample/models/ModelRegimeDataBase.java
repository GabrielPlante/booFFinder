package sample.models;

import java.util.ArrayList;

public class ModelRegimeDataBase {

    private static ArrayList<ModelRegime> regimes;

    public ModelRegimeDataBase() {

        regimes = new ArrayList<>();
        regimes.add(new ModelRegime("Gourmand"));
        regimes.add(new ModelRegime("Sans Gluten"));
        regimes.add(new ModelRegime("Végétarien"));
        regimes.add(new ModelRegime("Sportif"));
        regimes.add(new ModelRegime("Haute Calories"));

    }

    public static ArrayList<ModelRegime> getRegimes() {
        return regimes;
    }
}
