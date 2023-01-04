package taxi;

import java.sql.Date;

public class FactureTable {

    int id ;
    String num, prix ;
    Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public String getPrix() {
        return prix;
    }

    public Date getDate() {
        return date;
    }



    public FactureTable(int id, String num, String prix, Date date) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.prix = prix;
    }
}
