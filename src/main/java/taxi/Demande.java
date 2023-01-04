package taxi;
import java.sql.Date;
public class Demande {
    int id;
    String client;
    String chauffeur;
    String statut;
    Date date;



    public Demande(){
        super();
    }

    public Demande(int id, String client, String chauffeur,Date date,String statut){
        this.id=id;
        this.client=client;
        this.chauffeur=chauffeur;
        this.date=date;
        this.statut=statut;

    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChauffeur() {
        return chauffeur;
    }

        public void setChauffeur(String chauffeur) {
        this.chauffeur = chauffeur;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}
