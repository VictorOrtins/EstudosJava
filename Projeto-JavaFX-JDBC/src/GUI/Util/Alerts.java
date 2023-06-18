package GUI.Util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
    public static void showAlert(String title, String header, String content, AlertType type){
        Alert alert = new Alert(type);
        //É intuitivo msm. A janela é divida entre Header e Content. O title fica no título de qualquer janela
        alert.setTitle(title);
        alert.setHeaderText(header); 
        alert.setContentText(content);
        alert.show();
    }
}
