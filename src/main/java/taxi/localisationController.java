package taxi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.DatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.ZoneId;
import java.util.ResourceBundle;


public class localisationController implements Initializable {
    public TextField arriv;
    public TextField dep;

    public TextField clientL;
    public TextField chauffL;
    @FXML
    private TableView<Localisation> LocTable;

    @FXML
    private Button acceuil;

    @FXML
    private Button ajouterL;

    @FXML
    private Button btndcx;

    @FXML
    private Button chauffeur;

    @FXML
    private Button client;

    @FXML
    private TableColumn<Localisation, Date> cln_dateL;

    @FXML
    private TableColumn<Localisation, Integer> cln_idL;

    public TableColumn<Localisation, String> cln_clientL;
    public TableColumn<Localisation, String> cln_chauffL;
    @FXML
    private TableColumn<Localisation, String> cln_depart;



    @FXML
    private TableColumn<Localisation, String> cln_arrivee;;

    @FXML
    private DatePicker dateL;

    @FXML
    private Button demande;

    @FXML
    private Button fact;

    @FXML
    private TextField idL;

    @FXML
    private Label label;

    @FXML
    private Button localisation;

    @FXML
    private Button modifierL;



    @FXML
    private Button profile;

    @FXML
    private TextField searchL;

    @FXML
    private Button searchLocal;

    @FXML
    private Button suppL;

    @FXML
    private AnchorPane table;

    @FXML
    private Button taxi;

    @FXML
    void Ajouter(ActionEvent event) {

    }

    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void SuppL(MouseEvent mouseEvent) {
        String sql="delete from localisation where client='"+searchL.getText()+"'";
        try{
            st=cnx.prepareStatement(sql);
            st.execute();
            clientL.setText("");
            chauffL.setText("");
            dep.setText("");
            arriv.setText("");
            dateL.setValue(null);


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Localisation supprime avec succes =" + searchL.getText() + "", javafx.scene.control.ButtonType.OK);

            alert.showAndWait();
            showLocalisation();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Supprimer(ActionEvent event) {

    }

    @FXML
    void UpdateL(MouseEvent mouseEvent) {
        String client = clientL.getText();
        String chauffeur = chauffL.getText();
        String depart = dep.getText();
        String arrivee = arriv.getText();



        String sql = "update localisation set client=?,chauffeur=?,depart=?,arrivee=?,date=? where client='"+searchL.getText()+"'";
        if (!client.equals("")&& !chauffeur.equals("")&& !depart.equals("")&& !arrivee.equals("") && !dateL.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, client);
                st.setString(2, chauffeur);
                st.setString(3, depart);
                st.setString(4, arrivee);

                java.util.Date date= java.util.Date.from(dateL.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date sqlDate = new Date(date.getTime());
                st.setDate(5, sqlDate);

                st.execute();

                clientL.setText("");
                chauffL.setText("");
                dep.setText("");
                arriv.setText("");
                dateL.setValue(null);


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Localisation modifie avec succes " + searchL.getText() + "", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showLocalisation();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !" + searchL.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    void addL(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String client = clientL.getText();
        String chauffeur = chauffL.getText();
        String depart = dep.getText();
        String arrivee = arriv.getText();



        String sql = "insert into localisation(client,chauffeur,depart,arrivee,date) values (?,?,?,?,?)";
        if (!client.equals("") && !chauffeur.equals("")&& !depart.equals("") && !arrivee.equals("") && !dateL.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, client);
                st.setString(2, chauffeur);
                st.setString(3, depart);
                st.setString(4, arrivee);

                java.util.Date date= java.util.Date.from(dateL.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date sqlDate = new Date(date.getTime());
                st.setDate(5, sqlDate);

                st.execute();

                clientL.setText("");
                chauffL.setText("");
                dep.setText("");
                arriv.setText("");
                dateL.setValue(null);


                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Localisation ajoute avec succes " , javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showLocalisation();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !" , javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
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
    void openTaxi(ActionEvent event) throws IOException {
        taxi.getScene().getWindow().hide();
        Stage taxi=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Taxis.fxml"));
        Scene scene=new Scene(fxml);
        taxi.setScene(scene);
        taxi.show();
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
    void openClients(ActionEvent event) throws IOException {
        client.getScene().getWindow().hide();

        Stage client=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("client.fxml"));
        Scene scene=new Scene(fxml);
        client.setScene(scene);
        client.show();


    }@FXML
    void openDemandes(ActionEvent event) throws IOException {
        demande.getScene().getWindow().hide();
        Stage demande=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Demandes.fxml"));
        Scene scene=new Scene(fxml);
        demande.setScene(scene);
        demande.show();

    }



    @FXML
    void openFactures(ActionEvent event) throws IOException {
        fact.getScene().getWindow().hide();
        Stage facture=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Facture.fxml"));
        Scene scene=new Scene(fxml);
        facture.setScene(scene);
        facture.show();

    }



    public void logout(ActionEvent actionEvent) throws IOException {
        btndcx.getScene().getWindow().hide();
        Stage logout=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene=new Scene(fxml);
        logout.setScene(scene);
        logout.show();

    }

    @FXML
    void openLocalisation(ActionEvent event) throws IOException {
        Stage local=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("localisation.fxml"));
        Scene scene=new Scene(fxml);
        local.setScene(scene);
        local.show();
    }



    @FXML
    void searchL(ActionEvent actionEvent) {
        cnx = ConnexionMysql.connexionDB();

        String sql = "select id,client,chauffeur,depart,arrivee,date from localisation where client='" + searchL.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                clientL.setText(result.getString("client"));
                chauffL.setText(result.getString("chauffeur"));
                dep.setText(result.getString("depart"));
                arriv.setText(result.getString("arrivee"));
                Date date=result.getDate("date");
                dateL.setValue(date.toLocalDate());
                m=1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m==0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucun localisation trouve avec id =" + searchL.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    void searchLocalisation(MouseEvent event) {

    }
    public ObservableList<Localisation> data = FXCollections.observableArrayList();
    @FXML
    private Parent fxml;

    @FXML
    private AnchorPane root;
    public PreparedStatement st;
    public ResultSet result;
    public Connection cnx=null;
    public static Connection connexionDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/taxiapp","root","");

            return cnx;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void showLocalisation() {
        LocTable.getItems().clear();
        String sql = "select * from localisation";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()) {
                data.add(new Localisation(result.getInt("id"), result.getString("client"),result.getString("chauffeur"),result.getString("depart"),result.getString("arrivee"), result.getDate("date")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        cln_clientL.setCellValueFactory(new PropertyValueFactory<Localisation, String>("client"));
        cln_chauffL.setCellValueFactory(new PropertyValueFactory<Localisation, String>("chauffeur"));
        cln_depart.setCellValueFactory(new PropertyValueFactory<Localisation, String>("depart"));
        cln_arrivee.setCellValueFactory(new PropertyValueFactory<Localisation, String>("arrivee"));
        cln_idL.setCellValueFactory(new PropertyValueFactory<Localisation, Integer>("id"));
        cln_dateL.setCellValueFactory(new PropertyValueFactory<Localisation, Date>("date"));

        LocTable.setItems(data);

    }
    public void initialize(URL arg0, ResourceBundle argl) {
        cnx = ConnexionMysql.connexionDB();

        showLocalisation();
    }
}
