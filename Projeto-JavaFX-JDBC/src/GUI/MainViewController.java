package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Interfaces.OpenWindowInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable, OpenWindowInterface{

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction(){
        this.openWindow2("/GUI/DepartmentListView.fxml");
    }

    @FXML
    public void onMenuItemAboutAction(){
        this.openWindow("/GUI/AboutView.fxml");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {     

    }

    
}
