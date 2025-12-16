package contoller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerDTO;
import service.CustomerService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

    CustomerService customerService = new CustomerService();

    @FXML
    private TableColumn<CustomerDTO, String> colContactNo;

    @FXML
    private TableColumn<CustomerDTO, String> colCusID;

    @FXML
    private TableColumn<CustomerDTO, String> colEmail;

    @FXML
    private TableColumn<CustomerDTO, String> colName;

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblCusID;

    @FXML
    private Label lblDate;

    @FXML
    private TableView<CustomerDTO> tblCustomerDetails;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPhoneNo;

    @FXML
    void btnAddCusOnAction(ActionEvent event) {
        String cusId = lblCusID.getText();
        String name = txtName.getText();
        String phoneNo = txtPhoneNo.getText();
        String email = txtEmail.getText();

        CustomerDTO customerDTO = new CustomerDTO(cusId,name,phoneNo,email);

        customerService.addCustomer(customerDTO);

        setNewID();

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

    private void loadCustomers(){
        customerDTOS.clear();
        customerDTOS.addAll(customerService.getAllCustomers());
        tblCustomerDetails.setItems(customerDTOS);
    }

    public void setNewID(){
        //----------------Set New ID----------------//
        String lastCusId = customerService.getLastCustomerId();
        if (lastCusId == null){
            lastCusId = "C000";
        }
        int numericPart = Integer.parseInt(lastCusId.substring(1));
        numericPart++;
        String newId = String.format("C%03d", numericPart);
        lblCusID.setText(newId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setNewID();

        colCusID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblCustomerDetails.setItems(customerDTOS);

        loadCustomers();

    }
}
