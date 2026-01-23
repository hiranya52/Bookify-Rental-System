package contoller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.dto.RentalDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import service.RentalServiceImpl;
import service.impl.RentalService;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class ReportsInfoController implements Initializable {

    private RentalService rentalService = new RentalServiceImpl();

    private ObservableList<RentalDTO> rentalDTOS = FXCollections.observableArrayList();

    @FXML
    private Label txtActiveRentals;

    @FXML
    private Label txtOverdueRentals;

    @FXML
    private Label txtTotalBooks;


    private void getAllRentals() {
        rentalDTOS.clear();
        List<RentalDTO> rentals = rentalService.getAllRentals();
        rentalDTOS.addAll(rentals);
    }

    @FXML
    void rentalReportOnAction(ActionEvent event) {

    }

    @FXML
    void returnsReportOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
