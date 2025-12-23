package contoller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.dto.UserDTO;
import service.UserServiceImpl;

public class UserInfoController {

    UserServiceImpl userService = new UserServiceImpl();

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

        UserDTO userDTO = new UserDTO(id,name,contact,address,email);

        userService.addUser(userDTO);


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
    void btnUserManagementOnAction(ActionEvent event) {

    }

}
