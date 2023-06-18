package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LayoutController implements Initializable{

    @FXML
    private Button btSum;

    @FXML
    private Label lblResultSum;

    @FXML
    private TextField tfFirstNumber;

    @FXML
    private TextField tfSecondNumber;

    @FXML
    void onBtSumAction(ActionEvent event) {
        try{
            double number1 = Double.parseDouble(tfFirstNumber.getText());
            double number2 = Double.parseDouble(tfSecondNumber.getText());
            double sum = number1 + number2;

            lblResultSum.setText(String.format("%.2f", sum));
        }
        catch(NumberFormatException e){
            Alerts.showAlert("ERROR", "Parse exception", e.getMessage(), AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Constraints.setTextFieldDouble(tfFirstNumber);
        Constraints.setTextFieldDouble(tfSecondNumber);
        Constraints.setTextFieldMaxLength(tfFirstNumber, 12);
        Constraints.setTextFieldMaxLength(tfSecondNumber, 12);
    }

}
