package contoller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BookInfoController implements Initializable {

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblDate;

    @FXML
    private Spinner<Integer> spnQty;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    void btnAddBookOnAction(ActionEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        spnQty.setValueFactory(valueFactory);
        spnQty.setEditable(true);

    }


}
