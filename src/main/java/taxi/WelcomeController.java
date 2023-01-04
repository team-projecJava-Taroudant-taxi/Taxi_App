package taxi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button tfCommencer;





    @FXML
    void btnCommencerClicked(ActionEvent event) throws IOException {
        tfCommencer.getScene().getWindow().hide();

        Stage welcome=new Stage();
       Parent root= FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene=new Scene(root);
        welcome.setScene(scene);
        welcome.show();


    }


}
