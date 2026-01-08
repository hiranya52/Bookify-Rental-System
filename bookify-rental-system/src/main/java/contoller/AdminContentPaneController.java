package contoller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminContentPaneController implements Initializable {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private JFXButton btnBooks;

    @FXML
    private JFXButton btnCustomers;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnRentals;

    @FXML
    private JFXButton btnReports;

    @FXML
    private JFXButton btnReturns;

    @FXML
    private JFXButton btnUserManagement;

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: white;");
        btnBooks.setStyle("-fx-text-fill: #e83c75;");
        btnCustomers.setStyle("-fx-text-fill: white;");
        btnRentals.setStyle("-fx-text-fill: white;");
        btnReturns.setStyle("-fx-text-fill: white;");
        btnReports.setStyle("-fx-text-fill: white;");
        btnUserManagement.setStyle("-fx-text-fill: white;");
        loadUI("/view/book_info.fxml");
    }

    @FXML
    void btnCustomersOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: white;");
        btnBooks.setStyle("-fx-text-fill: white;");
        btnCustomers.setStyle("-fx-text-fill: #e83c75;");
        btnRentals.setStyle("-fx-text-fill: white;");
        btnReturns.setStyle("-fx-text-fill: white;");
        btnReports.setStyle("-fx-text-fill: white;");
        btnUserManagement.setStyle("-fx-text-fill: white;");
        loadUI("/view/customer_info.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: #e83c75;");
        btnBooks.setStyle("-fx-text-fill: white;");
        btnCustomers.setStyle("-fx-text-fill: white;");
        btnRentals.setStyle("-fx-text-fill: white;");
        btnReturns.setStyle("-fx-text-fill: white;");
        btnReports.setStyle("-fx-text-fill: white;");
        btnUserManagement.setStyle("-fx-text-fill: white;");
        loadUI("/view/admin_dashboard.fxml");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        loadUI("/view/login_form.fxml");
    }

    @FXML
    void btnRentalsOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: white;");
        btnBooks.setStyle("-fx-text-fill: white;");
        btnCustomers.setStyle("-fx-text-fill: white;");
        btnRentals.setStyle("-fx-text-fill: #e83c75;");
        btnReturns.setStyle("-fx-text-fill: white;");
        btnReports.setStyle("-fx-text-fill: white;");
        btnUserManagement.setStyle("-fx-text-fill: white;");
        loadUI("/view/rental_info.fxml");
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: white;");
        btnBooks.setStyle("-fx-text-fill: white;");
        btnCustomers.setStyle("-fx-text-fill: white;");
        btnRentals.setStyle("-fx-text-fill: white;");
        btnReturns.setStyle("-fx-text-fill: white;");
        btnReports.setStyle("-fx-text-fill: #e83c75;");
        btnUserManagement.setStyle("-fx-text-fill: white;");
        loadUI("/view/reports_info.fxml");

    }

    @FXML
    void btnReturnsOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: white;");
        btnBooks.setStyle("-fx-text-fill: white;");
        btnCustomers.setStyle("-fx-text-fill: white;");
        btnRentals.setStyle("-fx-text-fill: white;");
        btnReturns.setStyle("-fx-text-fill: #e83c75;");
        btnReports.setStyle("-fx-text-fill: white;");
        btnUserManagement.setStyle("-fx-text-fill: white;");
        loadUI("/view/returns_info.fxml");
    }

    @FXML
    void btnUserManagementOnAction(ActionEvent event) {
        btnDashboard.setStyle("-fx-text-fill: white;");
        btnBooks.setStyle("-fx-text-fill: white;");
        btnCustomers.setStyle("-fx-text-fill: white;");
        btnRentals.setStyle("-fx-text-fill: white;");
        btnReturns.setStyle("-fx-text-fill: white;");
        btnReports.setStyle("-fx-text-fill: white;");
        btnUserManagement.setStyle("-fx-text-fill: #e83c75;");
        loadUI("/view/user_info.fxml");
    }

    private void loadUI(String path) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(path));
            contentPane.getChildren().clear();
            contentPane.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadUI("/view/admin_dashboard.fxml");

    }
}
