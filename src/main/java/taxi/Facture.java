package taxi;
import java.sql.Date;
public class Facture {
    int id;
    String num;
    Date date;
    String prix;

    public Facture(){
        super();
    }

    public Facture(int id, String num, Date date,String prix){
        this.id=id;
        this.num=num;
        this.date=date;
        this.prix=prix;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getPrix() {

        return prix;
    }

    public void setPrix(String prix) {

        this.prix = prix;
    }
}
