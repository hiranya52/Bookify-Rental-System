package contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BooksController {

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        try {
            // Load dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/books_info.fxml"));
            Scene scene = new Scene(loader.load());

            // Get current stage from event source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
