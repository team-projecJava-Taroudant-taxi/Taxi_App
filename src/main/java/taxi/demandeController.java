package taxi;
import java.sql.Date;//REPRESENTE LA DATE QUI PEUT ETRE STOCKEE DANS LA BASE DE DONNEE
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class demandeController implements Initializable {
 public TextField searchDm;
    public Button searchDemande;
//initialisation de cnx
    public Connection cnx = null;
    public Button suppDm;
    public TableColumn cln_statut;
    public TextField stat;

    //Connexion base de donnee
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

    //action du boutton recherche:
    public void searchdm(ActionEvent actionEvent) {
        cnx = ConnexionMysql.connexionDB();

        String sql = "select client,chauffeur,date,statut from demande where client='" + searchDm.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                clientDm.setText(result.getString("client"));
                chauff.setText(result.getString("chauffeur"));
                Date date = result.getDate("date");
                stat.setText(result.getString("statut"));
                m = 1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucune demande trouvee " + searchDm.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    private TableColumn<Demande, Integer> cln_idD;

    @FXML
    private Button fact;

    @FXML
    private Button localisation;

    @FXML
    private Button profile;

    @FXML
    private TableColumn<Demande, String> cln_chauff;

    @FXML
    private Button taxi;

    @FXML
    private Button chauffeur;


    @FXML
    private Button btndcx;

    @FXML
    private Button demande;

    @FXML
    private Button ajouterDm;

    @FXML
    private TableColumn<Demande, Date> cln_date;

    @FXML
    private TextField idDm;

    @FXML
    private TextField chauff;

    @FXML
    private TextField clientDm;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button client;

    @FXML
    private Button acceuil;

    @FXML
    private Button modifierDm;

    @FXML
    private TableColumn<Demande, String> cln_clientDm;

    @FXML
    private AnchorPane table;

    @FXML
    private TableView<Demande> DmTable;


    public ObservableList<Demande> data = FXCollections.observableArrayList();//affiche contenue du table demande

    @FXML
    void open(ActionEvent event) throws IOException {
        acceuil.getScene().getWindow().hide();
        Stage acceuil = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Scene scene = new Scene(fxml);
        acceuil.setScene(scene);
        acceuil.show();

    }

    @FXML
    private Parent fxml;


    @FXML
    void openLocalisation(ActionEvent event) throws IOException {
        localisation.getScene().getWindow().hide();

        Stage local = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("localisation.fxml"));
        Scene scene = new Scene(fxml);
        local.setScene(scene);
        local.show();

    }


    @FXML
    void openTaxi(ActionEvent event) throws IOException {
        taxi.getScene().getWindow().hide();

        Stage taxi = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("Taxis.fxml"));
        Scene scene = new Scene(fxml);
        taxi.setScene(scene);
        taxi.show();

    }

    @FXML
    void openClients(ActionEvent event) throws IOException {
        client.getScene().getWindow().hide();

        Stage client = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("client.fxml"));
        Scene scene = new Scene(fxml);
        client.setScene(scene);
        client.show();

    }

    @FXML
    void openChauffeurs(ActionEvent event) throws IOException {
        chauffeur.getScene().getWindow().hide();

        Stage chauffeurs = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("Chauff.fxml"));
        Scene scene = new Scene(fxml);
        chauffeurs.setScene(scene);
        chauffeurs.show();


    }

    @FXML
    void openDemandes(ActionEvent event) throws IOException {
        demande.getScene().getWindow().hide();

        Stage demande = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("Demandes.fxml"));
        Scene scene = new Scene(fxml);
        demande.setScene(scene);
        demande.show();

    }

    @FXML
    void openFactures(ActionEvent event) throws IOException {
        fact.getScene().getWindow().hide();

        Stage facture = new Stage();
        fxml = FXMLLoader.load(getClass().getResource("Facture.fxml"));
        Scene scene = new Scene(fxml);
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

    public void showDm() {
       DmTable.getItems().clear();
        String sql = "select * from demande";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()) {
                data.add(new Demande(result.getInt("id"), result.getString("client"),result.getString("chauffeur"), result.getDate("date"), result.getString("statut")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        cln_clientDm.setCellValueFactory(new PropertyValueFactory<Demande, String>("client"));
        cln_idD.setCellValueFactory(new PropertyValueFactory<Demande, Integer>("id"));
        cln_chauff.setCellValueFactory(new PropertyValueFactory<Demande, String>("chauffeur"));
        cln_date.setCellValueFactory(new PropertyValueFactory<Demande, Date>("date"));
        cln_statut.setCellValueFactory(new PropertyValueFactory<Demande, String>("statut"));
        DmTable.setItems(data);

    }

    public void initialize(URL arg0, ResourceBundle argl) {
        cnx = ConnexionMysql.connexionDB();

        showDm();
    }


    public void UpdateDm(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String client = clientDm.getText();
        String chauffeur = chauff.getText();
        String statut = stat.getText();
        String sql = "update demande set client=?,chauffeur=?,date=?,statut=? where client='" + searchDm.getText() + "'";
        if (!client.equals("") && !chauffeur.equals("") && !datePicker.getValue().equals(null) && !statut.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, client);
                st.setString(2, chauffeur);
                java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date sqlDate = new Date(date.getTime());
                st.setDate(3, sqlDate);
                st.setString(4, statut);
                st.executeUpdate();

                clientDm.setText("");
                chauff.setText("");
                datePicker.setValue(null);
                stat.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Demande " + clientDm.getText() + "  ajouter avec succes ", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showDm();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }


    }


    public void SuppDm(MouseEvent mouseEvent) {

        String sql = "delete from demande where client='" + searchDm.getText() + "'";
        try {
            st = cnx.prepareStatement(sql);
            st.executeUpdate();
            clientDm.setText("");
            chauff.setText("");
            datePicker.setValue(null);
            stat.setText("");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Demande  " + searchDm.getText() + " supprime avec succes ", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
            showDm();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addDm(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String client = clientDm.getText();
        String chauffeur = chauff.getText();
        String statut = stat.getText();
        String sql = "insert into demande(client,chauffeur,date,statut) values (?,?,?,?)";
        if (!client.equals("") && !chauffeur.equals("") && !datePicker.getValue().equals(null) && !statut.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, client);
                st.setString(2, chauffeur);
                java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date sqlDate = new Date(date.getTime());
                st.setDate(3, sqlDate);
                st.setString(4, statut);
                st.execute();

                clientDm.setText("");
                chauff.setText("");
                datePicker.setValue(null);
                stat.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Demande " + clientDm.getText() + "  ajouter avec succes ", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showDm();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    public void searchDm(MouseEvent mouseEvent) {
        String sql = "select client,chauffeur,date,statut from demande where client='" + searchDm.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                clientDm.setText(result.getString("client"));
                chauff.setText(result.getString("chauffeur"));
                Date date = result.getDate("date");
                datePicker.setValue(date.toLocalDate());
                stat.setText(result.getString("statut"));

                m = 1;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucune Demande trouve " + searchDm.getText() + "", ButtonType.OK);
            alert.showAndWait();

        }
    }



}






