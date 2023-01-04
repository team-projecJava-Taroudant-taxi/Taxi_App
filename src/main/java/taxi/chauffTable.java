package taxi;

public class chauffTable {

    int id ;
    String nom, prenom, tel ;

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }



    public chauffTable(int id, String nom, String prenom, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }
}
