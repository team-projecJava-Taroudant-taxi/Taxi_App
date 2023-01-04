package taxi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class logController implements Initializable {
    Connection cnx;
    public PreparedStatement st;
    public ResultSet result;

    @FXML
    private TextField tfusename;

    @FXML
    private Button btnConnecter;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private Button btnInscrire;

    @FXML
    void ffc108(ActionEvent event) {

    }

    @FXML
    void btnInscrireClicked() throws IOException {
        btnInscrire.getScene().getWindow().hide();

        Stage Signup=new Stage();
        Parent fxml= FXMLLoader.load(getClass().getResource("reg.fxml"));
        Scene scene=new Scene(fxml);
        Signup.setScene(scene);
        Signup.show();
    }

    @FXML
private AnchorPane Anchorpane;

    @FXML
    private Parent fxml;

    @FXML
    private ActionEvent event;
    @FXML
    void btnConnecterClicked() throws IOException {
        String username=tfusename.getText();
        String password=tfpassword.getText();
        String sql="select * from register  where username='"+tfusename.getText()+"'";
try {
    st=cnx.prepareStatement(sql);
    result=st.executeQuery();
    if(result.next()){

     if(username.equals(result.getString("username")) && password.equals(result.getString("password"))){

         try {
             Stage home=new Stage();
             btnConnecter.getScene().getWindow().hide();

             fxml = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                Scene scene = new Scene(fxml);
                home.setScene(scene);
                home.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Bienvenue  "+ tfusename.getText() + "" , javafx.scene.control.ButtonType.OK);
         alert.showAndWait();
     }else{
             Alert alert=new Alert(Alert.AlertType.ERROR,"nom d'utilisateur ou mot de passe est incorrect!", ButtonType.OK);
             alert.showAndWait();

    }
         }
    } catch (SQLException e) {
    throw new RuntimeException(e);
}


    }


    @Override
    public void initialize(URL arg0, ResourceBundle argl) {
        cnx=ConnexionMysql.connexionDB();

    }
}
