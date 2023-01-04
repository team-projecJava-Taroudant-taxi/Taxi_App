package taxi;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class StatiController {

    public Button btndcx;
    public Button acceuil;
    public TextField taxi;
    public TextField chauff;
    public TextField cl;
    public Button nbTaxis;
    public Button chauffeurs;
    public Button client;


    @FXML
    private Parent fxml;

    @FXML
    private AnchorPane root;



    public void logout(ActionEvent actionEvent) throws IOException {
        btndcx.getScene().getWindow().hide();
        Stage logout=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene=new Scene(fxml);
        logout.setScene(scene);
        logout.show();

    }

    public void retour(ActionEvent actionEvent) throws IOException{
        acceuil.getScene().getWindow().hide();
        Stage acceuil=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene scene=new Scene(fxml);
        acceuil.setScene(scene);
        acceuil.show();
    }
    public PreparedStatement st;
    public ResultSet result;

    public Connection cnx = null;

    public static Connection connexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiapp", "root", "");

            return cnx;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





    public void nbtax(ActionEvent actionEvent) {
        try{
            cnx = ConnexionMysql.connexionDB();
            String sql="select count(immatriculation) from taxi";
            st= cnx.prepareStatement(sql);
            result=st.executeQuery();

            while(result.next()){
                taxi.setText(result.getString("count(immatriculation)"));

            }
            cnx.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public void nbChauff(ActionEvent actionEvent) {
        try{
            cnx = ConnexionMysql.connexionDB();
            String sql="select count(nom) from chauff";
            st= cnx.prepareStatement(sql);
            result=st.executeQuery();

            while(result.next()){
                chauff.setText(result.getString("count(nom)"));

            }
            cnx.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void nbClient(ActionEvent actionEvent) {
        try{
            cnx = ConnexionMysql.connexionDB();
            String sql="select count(nom) from client";
            st= cnx.prepareStatement(sql);
            result=st.executeQuery();

            while(result.next()){
                cl.setText(result.getString("count(nom)"));

            }
            cnx.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
