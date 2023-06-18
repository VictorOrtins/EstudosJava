package GUI;

import javafx.scene.control.TextField;

public class Constraints {
    public static void setTextFieldInteger(TextField txt){
        txt.textProperty().addListener( (obs, oldText, newText) -> {
            if(newText != null && !newText.matches("\\d*")){
                txt.setText(oldText);
            }
        });
    }

    public static void setTextFieldMaxLength(TextField txt, int max){
        txt.textProperty().addListener( (obs, oldText, newText) -> {
            if(newText != null && newText.length() > max){
                txt.setText(oldText);
            }
        });
    }

    public static void setTextFieldDouble(TextField txt){
        txt.textProperty().addListener( (obs, oldText, newText) -> {
            if(newText != null && !newText.matches("\\d*([\\.]\\d*)?")){
                txt.setText(oldText);
            }
        }); 
    }
}
