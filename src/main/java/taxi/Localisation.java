package taxi;

import java.sql.Date;

public class Localisation{
    int id;
    String client,chauffeur,depart,arrivee;
    Date date;


    public Localisation(){
        super();
    }

    public Localisation(int id, String client, String chauffeur, String depart, String arrivee, Date date ){
        this.id=id;
        this.client=client;
        this.chauffeur=chauffeur;
        this.depart=depart;
        this.arrivee=arrivee;
        this.date=date;

    }


    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }

    public String getChauffeur() {
        return chauffeur;
    }
    public void setChauffeur(String chauffeur) {
        this.chauffeur = chauffeur;
    }

    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }
    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
