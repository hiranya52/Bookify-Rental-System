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
    ObservableList<ReturnDTO> completeReturnDTOS = FXCollections.observableArrayList();

    RentalService rentalService = new RentalServiceImpl();

    ReturnService returnService = new ReturnServiceImpl();

    @FXML
    private TableColumn<?, ?> colCBookID;

    @FXML
    private TableColumn<?, ?> colCCustomerID;

    @FXML
    private TableColumn<?, ?> colCDueDate;

    @FXML
    private TableColumn<?, ?> colCFine;

    @FXML
    private TableColumn<?, ?> colCIssueDate;

    @FXML
    private TableColumn<?, ?> colCOverDueDate;

    @FXML
    private TableColumn<?, ?> colCRentalID;

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
    private TableView<ReturnDTO> tblCompleteReturnsDetails;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtCustomer;

    @FXML
    private JFXTextField txtFine;

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
        loadCompletedReturnDetails();
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

//----------------------Load Completed Return Details----------------------//
    public void loadCompletedReturnDetails(){

        completeReturnDTOS.clear();
        List<ReturnDTO> returnDTOS = returnService.getAllReturns();

        for ( ReturnDTO returnDTO : returnDTOS ) {
            completeReturnDTOS.add(new ReturnDTO(
                    returnDTO.getId(),
                    returnDTO.getBookId(),
                    returnDTO.getCustomerId(),
                    returnDTO.getIssueDate(),
                    returnDTO.getDueDate(),
                    returnDTO.getOverdueDays(),
                    returnDTO.getFine()

            ));
        }

    }

//----------------------Initialize----------------------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        loadRentalDetails();
        loadCompletedReturnDetails();

        colRentalID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colOverDueDate.setCellValueFactory(new PropertyValueFactory<>("overdueDays"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        tblRentDetails.setItems(returnDTOS);

        colCRentalID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colCCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colCIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colCDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        colCOverDueDate.setCellValueFactory(new PropertyValueFactory<>("overdueDays"));
        colCFine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        tblCompleteReturnsDetails.setItems(completeReturnDTOS);

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
