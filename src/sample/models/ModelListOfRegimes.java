package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfRegimes {

    private ObservableList<ModelRegime> regimes;

    public ModelListOfRegimes() {

        regimes = FXCollections.observableList(new ArrayList<>());

    }


    public void add(ModelRegime regime) {
        regimes.add(regime);
    }

    public void remove(ModelRegime regime) {
        regimes.remove(regime);

    }

    public void update(ArrayList<ModelRegime> regimes) {
        this.regimes.clear();
        this.regimes.addAll(regimes);
    }

    public ObservableList<ModelRegime> getRegimes() {
        return regimes;
    }
}
