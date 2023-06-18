package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Application.App;
import Model.Entities.Department;
import Model.Services.DepartmentListService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DepartmentListController implements Initializable{

    private DepartmentListService departmentService;

    private ObservableList<Department> listDepartment;

    @FXML
    private Button buttonNew;

    @FXML
    private TableView<Department> tblViewDepartmentList;

    @FXML
    private TableColumn<Department, Integer> tblColumnId;

    @FXML
    private TableColumn<Department, String> tblColumnName;


    @FXML
    public void onBtNewAction(){
        System.out.println("onBtNewAction");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes();
    }

    public void initializeNodes(){
        tblColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        Stage stage = (Stage) App.getMainScene().getWindow();
        tblViewDepartmentList.prefHeightProperty().bind(stage.heightProperty());
    }

    public void setDepartmentService(DepartmentListService dls){
        this.departmentService = dls;
    }

    public DepartmentListService getDepartmentListService(){
        return this.departmentService;
    }

    public void updateTableView(){
        if(departmentService == null){
            throw new IllegalStateException("Department Service was null");
        }

        List<Department> list = departmentService.findAll();
        listDepartment = FXCollections.observableArrayList(list);
        tblViewDepartmentList.setItems(listDepartment);
    }
    
}
