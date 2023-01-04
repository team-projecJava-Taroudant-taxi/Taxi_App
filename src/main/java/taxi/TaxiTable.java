package taxi;

import javafx.scene.input.MouseEvent;

import java.sql.Date;
import java.sql.SQLException;

public class TaxiTable {

    int id ;
    String immatriculation, marque, model ;

    public void setId(int id) {
        this.id = id;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public int getId() {
        return id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModel() {
        return model;
    }



    public TaxiTable(int id, String immatriculation, String marque, String model) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.model = model;
    }


}

