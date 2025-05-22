package com.mycompany.delivery;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
     @FXML
    private void RafaMaju() throws IOException {
        App.setRoot("secondary");
    }
}
