package contoller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.RentalDTO;
import model.dto.ReturnDTO;
import service.RentalServiceImpl;
import service.ReturnServiceImpl;
import service.impl.RentalService;
import service.impl.ReturnService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;

public class ReturnInfoController implements Initializable {

    ObservableList<ReturnDTO> returnDTOS = FXCollections.observableArrayList();

    RentalService rentalService = new RentalServiceImpl();

    ReturnService returnService = new ReturnServiceImpl();

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colFine;

    @FXML
    private TableColumn<?, ?> colIssueDate;

    @FXML
    private TableColumn<?, ?> colOverDueDate;

    @FXML
    private TableColumn<?, ?> colRentalID;

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblCusID;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblRentID;

    @FXML
    private TableView<ReturnDTO> tblRentDetails;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtCustomer;

    @FXML
    private JFXTextField txtFine;

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/admin_dashboard.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

//----------------------Clear Text Fields----------------------//
    private void clearTxtFields(){
        lblRentID.setText("");
        txtCustomer.setText("");
        txtBookId.setText("");
        txtFine.setText("");
    }

//----------------------Complete Rental----------------------//
    @FXML
    void btnCompleteRentalOnAction(ActionEvent event) {

        String id = lblRentID.getText();
        RentalDTO rentalDTO = rentalService.getRental(id);

        int overdueDays = getOverdueDays(LocalDate.parse(rentalDTO.getIssueDate()));
        int fine = overdueDays * 50;

        ReturnDTO returnDTO = new ReturnDTO(
                getLastReturnID(),
                rentalDTO.getBookId(),
                rentalDTO.getCustomerId(),
                rentalDTO.getIssueDate(),
                rentalDTO.getDueDate(),
                overdueDays,
                fine
        );
        returnService.addReturn(returnDTO);
        rentalService.deleteRental(id);
        loadRentalDetails();
        clearTxtFields();

    }

//----------------------Get Last Return ID----------------------//
    public String getLastReturnID(){

        String newId = "";
        String lastCusId = returnService.getLastReturnId();

        if (lastCusId == null) {
            newId = "R001";
        } else {
            int numericPart = Integer.parseInt(lastCusId.substring(1));
            numericPart++;
            newId = String.format("R%03d", numericPart);
        }
        return newId;
    }

//----------------------Get Overdue Days----------------------//
    private int getOverdueDays(LocalDate issueDate) {
        LocalDate today = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(7);

        if (today.isAfter(dueDate)) {
            return (int) ChronoUnit.DAYS.between(dueDate, today);
        }
        return 0;
    }


    //----------------------Load Rental Details----------------------//
    private void loadRentalDetails(){

        returnDTOS.clear();
        List<RentalDTO> rentalDTOList = rentalService.getAllRentals();

        for ( RentalDTO rentalDTO : rentalDTOList ) {

            int overdueDays = getOverdueDays(LocalDate.parse(rentalDTO.getIssueDate()));
            double fine = overdueDays * 50;

            returnDTOS.add(new ReturnDTO(
                    rentalDTO.getId(),
                    rentalDTO.getBookId(),
                    rentalDTO.getCustomerId(),
                    rentalDTO.getIssueDate(),
                    rentalDTO.getDueDate(),
                    overdueDays,
                    fine
            ));
        }
    }

//----------------------Initialize----------------------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        loadRentalDetails();

        colRentalID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colOverDueDate.setCellValueFactory(new PropertyValueFactory<>("overdueDays"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        tblRentDetails.setItems(returnDTOS);

        tblRentDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if ( newValue != null ){
                lblRentID.setText(newValue.getId());
                txtCustomer.setText(newValue.getCustomerId());
                txtBookId.setText(newValue.getBookId());
                txtFine.setText(String.valueOf(newValue.getFine()));
            }

        });


        }



}
