package contoller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbRole;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void btnLogInOnAction(ActionEvent event) {

        String role = cmbRole.getSelectionModel().getSelectedItem();

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (role.equals("Admin")){
            if (username.equals("Admin") && password.equals("Admin123")){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin_dashboard.fxml"));
                    Scene scene = new Scene(loader.load());

                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                    stage.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }else if (role.equals("Staff")){
            if (username.equals("Staff") && password.equals("Staff123")){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staff_dashboard.fxml"));
                    Scene scene = new Scene(loader.load());

                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                    stage.setScene(scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbRole.getItems().addAll("Admin","Staff");
    }
}
