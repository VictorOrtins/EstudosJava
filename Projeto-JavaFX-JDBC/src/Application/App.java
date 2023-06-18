package Application;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("/GUI/MainView.fxml"));
            ScrollPane scrollPane = fxml.load();

            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            scene = new Scene(scrollPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("New Project");
            primaryStage.show();
        }
        catch(IOException e){
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }

    public static Scene getMainScene(){
        return scene;
    }
}
