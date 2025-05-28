module com.mycompany.delivery {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.delivery to javafx.fxml;
    opens com.mycompany.delivery.Controller to javafx.fxml;

    exports com.mycompany.delivery;
}
