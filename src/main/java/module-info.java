module taxi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;



    opens taxi to javafx.fxml;
    exports taxi;
}