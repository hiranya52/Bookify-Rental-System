package contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private Label txtActiveRentals;

    @FXML
    private Label txtOverdueRentals;

    @FXML
    private Label txtTotalBooks;

    @FXML
    private Label txtTotalCustomers;

    @FXML
    void btnBooksOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/book_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnCustomersOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRentalsOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/rental_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnsOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/returns_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUserManagementOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user_info.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setLabel("Month");
//
//        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Sales (LKR)");
//
//        monthlySalesChart = new AreaChart<>(xAxis, yAxis);
//        monthlySalesChart.setTitle("Monthly Sales Performance");
//
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        series.setName("2024");
//
//        series.getData().add(new XYChart.Data<>("January", 45000));
//        series.getData().add(new XYChart.Data<>("February", 38000));
//        series.getData().add(new XYChart.Data<>("March", 52000));
//        series.getData().add(new XYChart.Data<>("April", 61000));
//        series.getData().add(new XYChart.Data<>("May", 70000));
//        series.getData().add(new XYChart.Data<>("June", 63000));
//        series.getData().add(new XYChart.Data<>("July", 72000));
//        series.getData().add(new XYChart.Data<>("August", 68000));
//        series.getData().add(new XYChart.Data<>("September", 54000));
//        series.getData().add(new XYChart.Data<>("October", 75000));
//        series.getData().add(new XYChart.Data<>("November", 82000));
//        series.getData().add(new XYChart.Data<>("December", 90000));
//
//        monthlySalesChart.getData().add(series);
//
//        monthlySalesChart.setLegendVisible(true);
//        monthlySalesChart.setAnimated(true);
//        monthlySalesChart.setStyle("-fx-stroke-width: 1.5;");

    }
}
