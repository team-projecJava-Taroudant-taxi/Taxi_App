package taxi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {


    public Button statistiques;
    @FXML
    private Button fact;



    @FXML
    private Button profile;

    @FXML
    private Button localisation;

    @FXML
    private Button taxi;

    @FXML
    private Button chauffeur;





    @FXML
    private Button btndcx;

    @FXML
    private Button demande;


    @FXML
    private Button client;

    @FXML
    private Button acceuil;




    @FXML
    void Ajouter(ActionEvent event) {

    }



    @FXML
    void Modifier(ActionEvent event) {

    }

    @FXML
    void Supprimer(ActionEvent event) {

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


    }
    @FXML
    private Parent fxml;

    @FXML
    private AnchorPane root;



    @FXML
    void client(MouseEvent event) {
        try {
            fxml= FXMLLoader.load(getClass().getResource("client.fxml"))  ;



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void acceuil(MouseEvent mouseEvent) {
        try{
            fxml=FXMLLoader.load(getClass().getResource("acceuil.fxml"));




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public void taxis(MouseEvent mouseEvent) {
        try{
            fxml=FXMLLoader.load(getClass().getResource("Taxis.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chauff(MouseEvent mouseEvent) {
        try{
            fxml=FXMLLoader.load(getClass().getResource("Chauff.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void demande(MouseEvent mouseEvent) {
        try{
            fxml=FXMLLoader.load(getClass().getResource("Demandes.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fact(MouseEvent mouseEvent) {
        try{
            fxml=FXMLLoader.load(getClass().getResource("Facture.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void local(MouseEvent mouseEvent) {
        try{
            fxml=FXMLLoader.load(getClass().getResource("localisation.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
    void openFactures(ActionEvent event) throws IOException {
        fact.getScene().getWindow().hide();
        Stage facture=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("Facture.fxml"));
        Scene scene=new Scene(fxml);
        facture.setScene(scene);
        facture.show();

    }



    @FXML
    void openLocalisation(ActionEvent event) throws IOException {
        localisation.getScene().getWindow().hide();

        Stage local=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("localisation.fxml"));
        Scene scene=new Scene(fxml);
        local.setScene(scene);
        local.show();

    }


    public void stati(ActionEvent actionEvent) throws IOException{
        localisation.getScene().getWindow().hide();

        Stage local=new Stage();
        fxml= FXMLLoader.load(getClass().getResource("stati.fxml"));
        Scene scene=new Scene(fxml);
        local.setScene(scene);
        local.show();
    }
}
