package contoller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.dto.UserDTO;
import service.UserServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

    UserServiceImpl userService = new UserServiceImpl();

    @FXML
    private JFXComboBox<String> cmbRole;

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblUserID;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtName;

    @FXML
    void btnAddUserOnAction(ActionEvent event) {

        String id = lblUserID.getText();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String role = cmbRole.getSelectionModel().getSelectedItem();

        UserDTO userDTO = new UserDTO(id,name,contact,address,email,role);
        userService.addUser(userDTO);

        setNewID();


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
        }

        int numericPart = Integer.parseInt(lastId.substring(1));
        numericPart++;
        newID = String.format("C%03d", numericPart);
        lblUserID.setText(newID);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setNewID();

        cmbRole.getItems().addAll("Admin","Staff");

    }


}
