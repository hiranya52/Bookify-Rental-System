package contoller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.dto.RentalDTO;
import model.dto.ReturnDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import service.RentalServiceImpl;
import service.ReturnServiceImpl;
import service.impl.RentalService;
import service.impl.ReturnService;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class ReportsInfoController implements Initializable {

    private JasperReport rentalReport;
    private JasperReport returnReport;

    private RentalService rentalService = new RentalServiceImpl();
    private ReturnService returnService = new ReturnServiceImpl();

    private ObservableList<RentalDTO> rentalDTOS = FXCollections.observableArrayList();
    private ObservableList<ReturnDTO>  returnDTOS = FXCollections.observableArrayList();

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

    private void getAllReturns() {
        returnDTOS.clear();
        List<ReturnDTO> returns = returnService.getAllReturns();
        returnDTOS.addAll(returns);
    }

    @FXML
    void rentalReportOnAction(ActionEvent event) {

        try {
            // 1️⃣ Load data
            getAllRentals();
            // 2️⃣ Create datasource
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new ArrayList<>(rentalDTOS));
            // 3️⃣ Fill report
            JasperPrint print = JasperFillManager.fillReport(rentalReport, new HashMap<>(), ds);
            // 4️⃣ Show report
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void returnsReportOnAction(ActionEvent event) {
        try {
            // 1️⃣ Load data
            getAllReturns();
            // 2️⃣ Create datasource
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(new ArrayList<>(returnDTOS));
            // 3️⃣ Fill report
            JasperPrint print = JasperFillManager.fillReport(rentalReport, new HashMap<>(), ds);
            // 4️⃣ Show report
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            rentalReport = JasperCompileManager.compileReport(
                    getClass().getResourceAsStream("/reports/rentalReport.jrxml")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            rentalReport = JasperCompileManager.compileReport(
                    getClass().getResourceAsStream("/reports/returnsReport.jrxml")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
