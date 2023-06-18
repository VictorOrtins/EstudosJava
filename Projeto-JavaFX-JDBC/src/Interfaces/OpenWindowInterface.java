package Interfaces;

import java.io.IOException;

import Application.App;
import GUI.DepartmentListController;
import GUI.Util.Alerts;
import Model.Services.DepartmentListService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;



public interface OpenWindowInterface {
    public default void openWindow(String absolutePath){
        try{
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(absolutePath));
            VBox newVBox = loader.load();

            Scene mainScene = App.getMainScene();
            VBox mainVBox = ( (VBox) ( (ScrollPane) mainScene.getRoot()).getContent());

            Node mainMenu = mainVBox.getChildren().get(0); //Menu Bar do MainView
            mainVBox.getChildren().clear(); //Tirando todos os filhos

            mainVBox.getChildren().add(mainMenu); //Adicionandoa menuBar no mainVBox
            mainVBox.getChildren().addAll(newVBox.getChildren()); //Adicionando todos os filhos da VBox criada
        }
        catch(IOException e){
            Alerts.showAlert("Error opening new window", "Error", e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public default void openWindow2(String absolutePath){
        try{
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(absolutePath));
            VBox newVBox = loader.load();

            Scene mainScene = App.getMainScene();
            VBox mainVBox = ( (VBox) ( (ScrollPane) mainScene.getRoot()).getContent());

            Node mainMenu = mainVBox.getChildren().get(0); //Menu Bar do MainView
            mainVBox.getChildren().clear(); //Tirando todos os filhos

            mainVBox.getChildren().add(mainMenu); //Adicionandoa menuBar no mainVBox
            mainVBox.getChildren().addAll(newVBox.getChildren()); //Adicionando todos os filhos da VBox criada

            DepartmentListController controller = loader.getController();
            controller.setDepartmentService(DepartmentListService.instantiateDepartmentService());
            controller.updateTableView();
        }
        catch(IOException e){
            Alerts.showAlert("Error opening new window", "Error", e.getMessage(), AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
