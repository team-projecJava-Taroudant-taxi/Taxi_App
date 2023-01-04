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

public class ClientController implements Initializable {

    public TextField searchCl;
    public Button searchClient;

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

        String sql = "select nom,prenom,tel from client where nom='" + searchCl.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                nomCl.setText(result.getString("nom"));
                prenomCl.setText(result.getString("prenom"));
                telCl.setText(result.getString("tel"));
               m=1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucun client trouve avec nom =" + searchCl.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    private TableColumn<Client, Integer> cln_id;

    @FXML
    private Button fact;

    @FXML
    private Button localisation;

    @FXML
    private Button profile;

    @FXML
    private TableColumn<Client, String> cln_prenom;

    @FXML
    private Button taxi;

    @FXML
    private Button chauffeur;

    @FXML
    private Button suppCl;


    @FXML
    private Label label;

    @FXML
    private Button btndcx;

    @FXML
    private Button demande;

    @FXML
    private Button ajouterCl;

    @FXML
    private TableColumn<Client, String> cln_tel;

    @FXML
    private TextField idCl;

    @FXML
    private TextField telCl;

    @FXML
    private TextField nomCl;

    @FXML
    private TextField prenomCl;

    @FXML
    private Button client;

    @FXML
    private Button acceuil;

    @FXML
    private Button modifierCl;

    @FXML
    private TableColumn<Client, String> cln_nom;

    @FXML
    private AnchorPane table;

    @FXML
    private TableView<Client> ClTable;


    public ObservableList<Client> data = FXCollections.observableArrayList();



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
    private AnchorPane root=null;

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

    public void showClient() {
        ClTable.getItems().clear();
        String sql = "select * from client";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()) {
                data.add(new Client(result.getInt("id"), result.getString("nom"), result.getString("prenom"), result.getString("tel")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        cln_nom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
        cln_id.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        cln_prenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
        cln_tel.setCellValueFactory(new PropertyValueFactory<Client, String>("tel"));
        ClTable.setItems(data);

    }

    public void initialize(URL arg0, ResourceBundle argl) {
        cnx = ConnexionMysql.connexionDB();

    showClient();
    }


    public void UpdateCL(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String nom = nomCl.getText();
        String prenom = prenomCl.getText();
        String tel = telCl.getText();
        String sql = "update client set nom=?,prenom=?,tel=? where nom='" + searchCl.getText() + "'";
        if (!nom.equals("") && !prenom.equals("") && !tel.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, nom);
                st.setString(2, prenom);
                st.setString(3, tel);
                st.execute();

                nomCl.setText("");
                prenomCl.setText("");
                telCl.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Client  " + searchCl.getText() + " modifie avec succes", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showClient();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !" , javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }



    public void SuppCL(MouseEvent mouseEvent) {

        String sql="delete from client where nom='" + searchCl.getText() + "'";
        try{
            st=cnx.prepareStatement(sql);
            st.execute();
            nomCl.setText("");
            prenomCl.setText("");
            telCl.setText("");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Client  " + searchCl.getText() + " supprime avec succes ", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
            showClient();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addCL(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String nom = nomCl.getText();
        String prenom = prenomCl.getText();
        String tel = telCl.getText();
        String sql = "insert into client(nom,prenom,tel) values (?,?,?)";
        if (!nom.equals("") && !prenom.equals("") && !tel.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, nom);
                st.setString(2, prenom);
                st.setString(3, tel);
                st.execute();

                nomCl.setText("");
                prenomCl.setText("");
                telCl.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Client "+ nomCl.getText() + "  ajouter avec succes ", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showClient();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !" , javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    public void searchClient(MouseEvent mouseEvent) {
        String sql = "select nom,prenom,tel from client where nom='" + searchCl.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                nomCl.setText(result.getString("nom"));
                prenomCl.setText(result.getString("prenom"));
                telCl.setText(result.getString("tel"));

                m=1;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucun client trouve " + searchCl.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }



    }


    


