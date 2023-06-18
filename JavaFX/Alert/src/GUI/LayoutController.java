package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class LayoutController {

    @FXML
    private Button button;

    @FXML
    void onButtonAction(ActionEvent event) {
        Alerts.showAlert("ALERTA", "WARNING", "DANGER", AlertType.CONFIRMATION);
    }

}
