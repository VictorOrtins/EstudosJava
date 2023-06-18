import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlPath = "GUI\\Layout.fxml";
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CheckBoxPerson");
        primaryStage.show();
    }
}
