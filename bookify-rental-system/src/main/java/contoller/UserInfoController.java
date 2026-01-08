package contoller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.dto.UserDTO;
import service.UserServiceImpl;
import service.impl.UserService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class UserInfoController implements Initializable {

    UserService userService = new UserServiceImpl();

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
    private GridPane userContainer;

//----------------------Add User----------------------//
    @FXML
    void btnAddUserOnAction(ActionEvent event) {

        String id = lblUserID.getText();
        String title = cmbTitle.getSelectionModel().getSelectedItem();
        String name = txtName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        String role = cmbRole.getSelectionModel().getSelectedItem();

        UserDTO userDTO = new UserDTO(id,title,name,contact,email,role);
        userService.addUser(userDTO);

        loadUsers();
        setNewID();
        clearTxtFields();

    }


//----------------------Delete User----------------------//
    @FXML
    void btnDeleteUserOnAction(ActionEvent event) {

        String id = lblUserID.getText();
        userService.deleteUser(id);

        loadUsers();
        setNewID();
        clearTxtFields();

    }

//----------------------Update User----------------------//
    @FXML
    void btnUpdateUserOnAction(ActionEvent event) {

        if( cmbTitle.getValue() != null && txtName.getText() != null && txtContact.getText() != null && txtEmail.getText() != null && cmbRole.getValue() != null ){

            String id = lblUserID.getText();
            String title = cmbTitle.getValue();
            String name = txtName.getText();
            String contact = txtContact.getText();
            String email = txtEmail.getText();
            String role = cmbRole.getValue();

            userService.updateUser(id,title,name,contact,email,role);

            loadUsers();
            setNewID();
            clearTxtFields();

        }

    }


//----------------------Set Date----------------------//
    private void setDate(){
        LocalDate currentDate = LocalDate.now();
        lblDate.setText(String.valueOf(currentDate));
    }

//----------------------Clear Text Fields----------------------//
    private void clearTxtFields(){
        cmbTitle.setValue(null);
        txtName.clear();
        txtContact.clear();
        txtEmail.clear();
        cmbRole.setValue(null);
    }

//----------------------Set New ID----------------------//
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

//----------------------Load Users----------------------//
    private void loadUsers(){

        userContainer.getChildren().clear();
        List<UserDTO> userDTOS = userService.getAllUsers();
        for (UserDTO userDTO : userDTOS){
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/view/user_card.fxml")
                );
                AnchorPane card = loader.load();
                UserCardController controller = loader.getController();
                controller.setUserData(userDTO.getTitle(),userDTO.getName(),userDTO.getRole(),userDTO.getContact());

                controller.setUserInfoController(this);

                int totalCards = userContainer.getChildren().size();
                int column = totalCards % 3;   // 0,1,2
                int row = totalCards / 3;      // auto increases

                userContainer.add(card, column, row);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//----------------------Load Selected User----------------------//
    public void loadSelectedUser(String phoneNo){

        UserDTO userDTO = userService.getUser(phoneNo);

        if ( userDTO != null ){
            lblUserID.setText(userDTO.getId());
            cmbTitle.setValue(userDTO.getTitle());
            txtName.setText(userDTO.getName());
            txtContact.setText(userDTO.getContact());
            txtEmail.setText(userDTO.getEmail());
            cmbRole.setValue(userDTO.getRole());
        }

    }

//----------------------Initialize----------------------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadUsers();
        setDate();
        setNewID();

        cmbRole.getItems().addAll("Admin","Staff");
        cmbTitle.getItems().addAll("Mr" , "Mrs");

    }


}
