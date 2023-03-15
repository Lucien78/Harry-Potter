module com.isep.hpah {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.isep.hpah to javafx.fxml;
    exports com.isep.hpah;
}