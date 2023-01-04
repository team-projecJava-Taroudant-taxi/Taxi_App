package taxi;
import java.sql.Date;
public class chauff {
    int id;
    String nom;
    String prenom;
    String tel;

    public chauff(){
        super();
    }

    public chauff(int id, String nom, String prenom,String tel){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
