package contoller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.BookDTO;
import model.dto.CustomerDTO;
import model.dto.RentalDTO;
import service.BookServiceImpl;
import service.CustomerServiceImpl;
import service.RentalServiceImpl;
import service.impl.BookService;
import service.impl.CustomerService;
import service.impl.RentalService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.String.valueOf;

public class RentalInfoController implements Initializable {

    RentalService rentalService = new RentalServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    BookService bookService = new BookServiceImpl();

    ObservableList<RentalDTO> rentalDTOS = FXCollections.observableArrayList();

    @FXML
    private JFXComboBox<String> cmbBookID;

    @FXML
    private JFXComboBox<String> cmbCustomerID;

    @FXML
    private TableColumn<?, ?> colRentalID;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colCusID;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colIssueDate;

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblCusID;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblRentID;

    @FXML
    private TableView<RentalDTO> tblRentDetails;


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

    //----------------------Add Rental----------------------//
    @FXML
    void btnDeleteRentalOnAction(ActionEvent event) {

        if ( lblRentID.getText() != null ) {

            String id = lblRentID.getText();
            rentalService.deleteRental(id);

            loadRentalDetails();
            setNewID();
            clearFields();

        }

    }

    //----------------------Add Rental----------------------//
    @FXML
    void btnRentOnAction(ActionEvent event) {

        String id = lblRentID.getText();
        String bookId = cmbBookID.getValue();
        String customerId = cmbCustomerID.getValue();
        String issueDate = getDate();
        String dueDate = getDueDate();

        RentalDTO rentalDTO = new RentalDTO(id,bookId,customerId,issueDate,dueDate);

        rentalService.addRental(rentalDTO);

        setNewID();
        clearFields();
        loadRentalDetails();

    }

//----------------------Update Rental----------------------//
    @FXML
    void btnUpdateRentalOnAction(ActionEvent event) {

        if (lblRentID.getText() != null || cmbBookID.getValue() != null || cmbCustomerID.getValue() != null){

            String rentalID = lblRentID.getText();
            String bookID = cmbBookID.getValue();
            String cusID = cmbCustomerID.getValue();

            rentalService.updateRental(rentalID,bookID,cusID);

            clearFields();
            setNewID();
            loadRentalDetails();

        }
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

//----------------------Load Rental Details----------------------//
    private void loadRentalDetails(){

        rentalDTOS.clear();

        List<RentalDTO> rentalDTOList = rentalService.getAllRentals();

        for (RentalDTO rentalDTO : rentalDTOList){
            rentalDTOS.add(new RentalDTO(
                    rentalDTO.getId(),
                    rentalDTO.getBookId(),
                    rentalDTO.getCustomerId(),
                    rentalDTO.getIssueDate(),
                    rentalDTO.getDueDate()
            ));
        }

        tblRentDetails.setItems(rentalDTOS);

    }


//----------------------Clear Fields----------------------//
    private void clearFields(){

        cmbBookID.setValue(null);
        cmbCustomerID.setValue(null);

    }

//----------------------set New ID----------------------//
    public void setNewID() {

        String newId = "";
        String lastCusId = rentalService.getLastRentalId();

        if (lastCusId == null) {
            newId = "R001";
        } else {
            int numericPart = Integer.parseInt(lastCusId.substring(1));
            numericPart++;
            newId = String.format("R%03d", numericPart);
        }

        lblRentID.setText(newId);
    }

//----------------------Get Due Date----------------------//
    private String getDueDate(){

        LocalDate currentDate = LocalDate.now();
        LocalDate nextWeekDate = currentDate.plusWeeks(1);
        return nextWeekDate.toString();

    }

//----------------------Get Date----------------------//
    private String getDate(){

        LocalDate currentDate = LocalDate.now();
        return String.valueOf(currentDate);

    }


//----------------------Initialize----------------------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setNewID();
        lblDate.setText(getDate());

        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        ObservableList<String> allCusIDs = FXCollections.observableArrayList();

        for (CustomerDTO customerDTO : allCustomers) {
            allCusIDs.add(customerDTO.getId());
        }
        cmbCustomerID.setItems(allCusIDs);

        ArrayList<BookDTO> allBooks = bookService.getAllBooks();
        ObservableList<String> allBookIDs = FXCollections.observableArrayList();

        for (BookDTO bookDTO : allBooks){
            allBookIDs.add(bookDTO.getId());
        }

        cmbBookID.setItems(allBookIDs);

        loadRentalDetails();

        colRentalID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colCusID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        tblRentDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue != null){
                lblRentID.setText(newValue.getId());
                cmbBookID.setValue(newValue.getBookId());
                cmbCustomerID.setValue(newValue.getCustomerId());
            }

        });

    }
}
