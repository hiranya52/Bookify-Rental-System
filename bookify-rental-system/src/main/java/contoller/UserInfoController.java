package contoller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import service.UserServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

    UserServiceImpl userService = new UserServiceImpl();

    @FXML
    private JFXComboBox<String> cmbRole;

    @FXML
    private JFXComboBox<String> cmbTitle;

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblUserID;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtName;

    @FXML
    private AnchorPane userContainer;

    @FXML
    void btnAddUserOnAction(ActionEvent event) {

    }

    @FXML
    void btnBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnCustomersOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteUserOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnRentalsOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnsOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateUserOnAction(ActionEvent event) {

    }

    @FXML
    void btnUserManagementOnAction(ActionEvent event) {

    }


    private void setNewID(){


        String newID = "";
        String lastId = userService.getLastUserId();


        if(lastId == null){
            newID = "E001";
        }else{
            int numericPart = Integer.parseInt(lastId.substring(1));
            numericPart++;
            newID = String.format("E%03d", numericPart);
        }

        lblUserID.setText(newID);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setNewID();

        cmbRole.getItems().addAll("Admin","Staff");
        cmbTitle.getItems().addAll("Mr" , "Mrs");

    }


}
