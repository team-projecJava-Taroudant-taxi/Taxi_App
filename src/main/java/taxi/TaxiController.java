package taxi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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

public class TaxiController implements Initializable {

    public TextField searchTX;
    public Button searchTaxi;

    public Connection cnx=null;
    public static Connection connexionDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiapp","root","");

            return cnx;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void search(ActionEvent actionEvent) {
        cnx = ConnexionMysql.connexionDB();

        String sql = "select immatriculation,marque,model from taxi where immatriculation='" + searchTX.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                matricul.setText(result.getString("immatriculation"));
                mrq.setText(result.getString("marque"));
                mdl.setText(result.getString("model"));
                m=1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucun Taxi trouve avec immatriculation =" + searchTX.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    private TableColumn<Taxi, Integer> cln_id;

    @FXML
    private Button fact;

    @FXML
    private Button localisation;

    @FXML
    private Button profile;

    @FXML
    private TableColumn<Taxi, String> cln_marque;

    @FXML
    private Button taxi;

    @FXML
    private Button chauffeur;

    @FXML
    private Button suppTx;




    @FXML
    private Button btndcx;

    @FXML
    private Button demande;

    @FXML
    private Button ajouterTx;

    @FXML
    private TableColumn<Taxi, String> cln_model;

    @FXML
    private TextField idTx;



    @FXML
    private TextField matricul;
    @FXML
    private TextField mrq;
    @FXML
    private TextField mdl;




    @FXML
    private Button client;

    @FXML
    private Button acceuil;

    @FXML
    private Button modifierTx;

    @FXML
    private TableColumn<Taxi, String> cln_matr;

    @FXML
    private AnchorPane table;

    @FXML
    private TableView<Taxi> TXTable;


    public ObservableList<Taxi> data = FXCollections.observableArrayList();



    public void logout(ActionEvent actionEvent) throws IOException {
        btndcx.getScene().getWindow().hide();

        Stage logout=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene=new Scene(fxml);
        logout.setScene(scene);
        logout.show();

    }
    @FXML
    void open(ActionEvent event) throws IOException {
        acceuil.getScene().getWindow().hide();
        Stage acceuil=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene scene=new Scene(fxml);
        acceuil.setScene(scene);
        acceuil.show();

    }

    @FXML
    private Parent fxml;



    @FXML
    void openLocalisation(ActionEvent event) throws IOException {
        localisation.getScene().getWindow().hide();

        Stage local=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("localisation.fxml"));
        Scene scene=new Scene(fxml);
        local.setScene(scene);
        local.show();

    }



    @FXML
    void openTaxi(ActionEvent event) throws IOException {
        taxi.getScene().getWindow().hide();

        Stage taxi=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Taxis.fxml"));
        Scene scene=new Scene(fxml);
        taxi.setScene(scene);
        taxi.show();

    }

    @FXML
    void openClients(ActionEvent event) throws IOException {
        client.getScene().getWindow().hide();

        Stage client=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("client.fxml"));
        Scene scene=new Scene(fxml);
        client.setScene(scene);
        client.show();

    }

    @FXML
    void openChauffeurs(ActionEvent event) throws IOException {
        chauffeur.getScene().getWindow().hide();

        Stage chauffeurs=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Chauff.fxml"));
        Scene scene=new Scene(fxml);
        chauffeurs.setScene(scene);
        chauffeurs.show();


    }

    @FXML
    void openDemandes(ActionEvent event) throws IOException {
        demande.getScene().getWindow().hide();

        Stage demande=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Demandes.fxml"));
        Scene scene=new Scene(fxml);
        demande.setScene(scene);
        demande.show();

    }

    @FXML
    void openFactures(ActionEvent event) throws IOException{
        fact.getScene().getWindow().hide();

        Stage facture=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Facture.fxml"));
        Scene scene=new Scene(fxml);
        facture.setScene(scene);
        facture.show();


    }

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

    }

    @FXML
    void Ajouter(ActionEvent event) {

    }

    public PreparedStatement st;
    public ResultSet result;

    public void showTaxi() {
        TXTable.getItems().clear();
        String sql = "select * from taxi";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()) {
                data.add(new Taxi(result.getInt("id"), result.getString("immatriculation"), result.getString("marque"), result.getString("model")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        cln_matr.setCellValueFactory(new PropertyValueFactory<Taxi, String>("immatriculation"));
        cln_id.setCellValueFactory(new PropertyValueFactory<Taxi, Integer>("id"));
        cln_marque.setCellValueFactory(new PropertyValueFactory<Taxi, String>("marque"));
        cln_model.setCellValueFactory(new PropertyValueFactory<Taxi, String>("model"));
        TXTable.setItems(data);

    }

    public void initialize(URL arg0, ResourceBundle argl) {
        cnx = ConnexionMysql.connexionDB();

        showTaxi();
    }


    public void UpdateTX(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();
        String immatriculation = matricul.getText();
        String marque= mrq.getText();
        String model = mdl.getText();
        String sql = "update taxi set immatriculation=?,marque=?,model=? where immatriculation='" + searchTX.getText() + "'";
        if (!immatriculation.equals("") && !marque.equals("") && !model.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, immatriculation);
                st.setString(2, marque);
                st.setString(3, model);
                st.execute();

                matricul.setText("");
                mrq.setText("");
                mdl.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Taxi  " + searchTX.getText() + " modifie avec succes", ButtonType.OK);
                alert.showAndWait();
                showTaxi();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !" , ButtonType.OK);
            alert.showAndWait();

        }
    }



    public void SuppTX(MouseEvent mouseEvent) {

        String sql="delete from taxi where immatriculation='" + searchTX.getText() + "'";
        try{
            st=cnx.prepareStatement(sql);
            st.execute();
            matricul.setText("");
            mrq.setText("");
            mdl.setText("");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Taxi  " + searchTX.getText() + " supprime avec succes ", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
            showTaxi();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addTX(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String immatriculation = matricul.getText();
        String marque = mrq.getText();
        String model = mdl.getText();
        String sql = "insert into taxi(immatriculation,marque,model) values (?,?,?)";
        if (!immatriculation.equals("") && !marque.equals("") && !model.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, immatriculation);
                st.setString(2, marque);
                st.setString(3, model);
                st.execute();

                matricul.setText("");
                mrq.setText("");
                mdl.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Taxi "+ matricul.getText() + "  ajouter avec succes ", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showTaxi();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !" , javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    public void searchTax(MouseEvent mouseEvent) {
        String sql = "select immatriculation,marque,model from taxi where immatriculation='" + searchTX.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                matricul.setText(result.getString("immatriculation"));
                mrq.setText(result.getString("marque"));
                mdl.setText(result.getString("model"));

                m=1;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucun taxi trouve " + searchTX.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }





}






