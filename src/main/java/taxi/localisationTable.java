package taxi;

import java.sql.Date;

public class localisationTable {
    int id ;
    String client,chauffeur,depart,arrivee;
    Date date;

    public void setId(int id) {
        this.id = id;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public void setChauffeur(String chauffeur) {
        this.chauffeur = chauffeur;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }
    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }
    public String getClient() {
        return client;
    }
    public String getChauffeur() {
        return chauffeur;
    }
    public String getDepart() {
        return depart;
    }
    public String getArrivee() {
        return arrivee;
    }
    public Date getDate() {
        return date;
    }


    public localisationTable(int id, String client,String chauffeur,String depart,String arrivee, Date date) {
        this.id = id;
        this.client = client;
        this.chauffeur = chauffeur;
        this.depart = depart;
        this.arrivee = arrivee;
        this.date = date;

    }
}
