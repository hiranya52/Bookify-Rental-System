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
import model.dto.BookDTO;
import model.dto.CustomerDTO;
import model.dto.RentalDTO;
import service.BookServiceImpl;
import service.CustomerServiceImpl;
import service.RentalServiceImpl;
import service.impl.BookService;
import service.impl.CustomerService;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.String.valueOf;

public class RentalInfoController implements Initializable {

    RentalServiceImpl rentalService = new RentalServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    BookService bookService = new BookServiceImpl();

    @FXML
    private JFXComboBox<String> cmbBookID;

    @FXML
    private JFXComboBox<String> cmbCustomerID;

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
    private TableView<?> tblRentDetails;


    @FXML
    void btnRentOnAction(ActionEvent event) {

        String id = lblRentID.getText();
        String bookId = cmbBookID.getSelectionModel().getSelectedItem();
        String customerId = cmbCustomerID.getSelectionModel().getSelectedItem();
        String issueDate = getDate();
        String dueDate = getDueDate();

        RentalDTO rentalDTO = new RentalDTO(id,bookId,customerId,issueDate,dueDate);

        rentalService.addRental(rentalDTO);

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

    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    private String getDueDate(){

        LocalDate currentDate = LocalDate.now();
        LocalDate nextWeekDate = currentDate.plusWeeks(1);
        return nextWeekDate.toString();

    }

    private String getDate(){

        LocalDate currentDate = LocalDate.now();
        return String.valueOf(currentDate);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    }
}
