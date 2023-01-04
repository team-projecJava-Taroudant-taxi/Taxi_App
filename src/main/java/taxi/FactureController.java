package taxi;
import java.sql.Date;

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

public class FactureController implements Initializable {

    public TextField searchfct;
    public Button searchFacture;

    public Connection cnx = null;
    public Button suppFact;

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

    public void searchfact(ActionEvent actionEvent) {
        cnx = ConnexionMysql.connexionDB();

        String sql = "select num,prix,date from facture where num='" + searchfct.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                numfact.setText(result.getString("num"));
                Date date = result.getDate("date");
                prixfact.setText(result.getString("prix"));
                m = 1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucune facture trouvee avec num =" + searchfct.getText() + "", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    @FXML
    private TableColumn<Facture, Integer> cln_idF;

    @FXML
    private Button fact;

    @FXML
    private Button localisation;

    @FXML
    private Button profile;

    @FXML
    private TableColumn<Facture, Date> cln_date;

    @FXML
    private Button taxi;

    @FXML
    private Button chauffeur;

    @FXML
    private Button suppfact;


    @FXML
    private Label label;

    @FXML
    private Button btndcx;

    @FXML
    private Button demande;

    @FXML
    private Button ajouterFact;

    @FXML
    private TableColumn<Facture, String> cln_prix;

    @FXML
    private TextField idfact;

    @FXML
    private TextField prixfact;

    @FXML
    private TextField numfact;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button client;

    @FXML
    private Button acceuil;

    @FXML
    private Button modifierfact;

    @FXML
    private TableColumn<Facture, String> cln_num;

    @FXML
    private AnchorPane table;

    @FXML
    private TableView<Facture> FactTable;


    public ObservableList<Facture> data = FXCollections.observableArrayList();

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

    public void showFact() {
        FactTable.getItems().clear();
        String sql = "select * from facture";
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            while (result.next()) {
                data.add(new Facture(result.getInt("id"), result.getString("num"), result.getDate("date"), result.getString("prix")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        cln_num.setCellValueFactory(new PropertyValueFactory<Facture, String>("num"));
        cln_idF.setCellValueFactory(new PropertyValueFactory<Facture, Integer>("id"));
        cln_prix.setCellValueFactory(new PropertyValueFactory<Facture, String>("prix"));
        cln_date.setCellValueFactory(new PropertyValueFactory<Facture, Date>("date"));
        FactTable.setItems(data);

    }

    public void initialize(URL arg0, ResourceBundle argl) {
        cnx = ConnexionMysql.connexionDB();

        showFact();
    }


    public void UpdateFact(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String num = numfact.getText();
        String prix = prixfact.getText();
        String sql = "update facture set num=?,date=?,prix=? where num='" + searchfct.getText() + "'";
        if (!num.equals("") && !datePicker.getValue().equals(null) && !prix.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, num);
                java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date sqlDate = new Date(date.getTime());
                st.setDate(2, sqlDate);
                st.setString(3, prix);
                st.executeUpdate();

                numfact.setText("");
                datePicker.setValue(null);
                prixfact.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Facture " + numfact.getText() + "  ajouter avec succes ", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showFact();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }


    }


    public void SuppFact(MouseEvent mouseEvent) {

        String sql = "delete from facture where num='" + searchfct.getText() + "'";
        try {
            st = cnx.prepareStatement(sql);
            st.executeUpdate();
            numfact.setText("");
            datePicker.setValue(null);
            prixfact.setText("");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Facture  " + searchfct.getText() + " supprime avec succes ", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
            showFact();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addfact(MouseEvent mouseEvent) {
        cnx = ConnexionMysql.connexionDB();

        String num = numfact.getText();
        String prix = prixfact.getText();
        String sql = "insert into facture(num,date,prix) values (?,?,?)";
        if (!num.equals("") && !datePicker.getValue().equals(null) && !prix.equals("")) {
            try {
                st = cnx.prepareStatement(sql);
                st.setString(1, num);
                java.util.Date date = java.util.Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date sqlDate = new Date(date.getTime());
                st.setDate(2, sqlDate);
                st.setString(3, prix);
                st.execute();

                numfact.setText("");
                datePicker.setValue(null);
                prixfact.setText("");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Facture " + numfact.getText() + "  ajouter avec succes ", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                showFact();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "veuillez remplir tous les champs !", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }
    }

    public void searchfacture(MouseEvent mouseEvent) {
        String sql = "select num,date,prix from facture where num='" + searchfct.getText() + "'";
        int m = 0;
        try {
            st = cnx.prepareStatement(sql);
            result = st.executeQuery();
            if (result.next()) {
                numfact.setText(result.getString("num"));
                Date date = result.getDate("date");
                datePicker.setValue(date.toLocalDate());
                prixfact.setText(result.getString("prix"));

                m = 1;


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (m == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "aucune Facture trouve " + searchfct.getText() + "", ButtonType.OK);
            alert.showAndWait();

        }
    }




}






