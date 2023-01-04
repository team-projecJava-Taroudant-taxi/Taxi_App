package taxi;
import java.sql.Date;
public class Taxi {
    int id;
    String immatriculation;
    String marque;
    String model;

    public Taxi(){
        super();
    }

    public Taxi(int id, String immatriculation, String marque,String model){
        this.id=id;
        this.immatriculation=immatriculation;
        this.marque=marque;
        this.model=model;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

