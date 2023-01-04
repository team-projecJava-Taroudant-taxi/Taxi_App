package taxi;

import java.sql.Date;

public class DemandeTable {

    int id ;
    String client, chauffeur,statut ;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



    public int getId() {
        return id;
    }

    public String getClient() { return client;}

    public String getChauffeur() {
        return chauffeur;
    }

    public Date getDate() {
        return date;
    }

    public String getStatut() {
        return statut;
    }



    public DemandeTable(int id, String client, String chauffeur, Date date, String statut) {
        this.id = id;
        this.client = client;
        this.chauffeur = chauffeur;
        this.date = date;
        this.statut = statut;
    }
}
