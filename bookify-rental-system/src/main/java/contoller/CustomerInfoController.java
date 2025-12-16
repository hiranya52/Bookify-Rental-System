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
import model.dto.CustomerDTO;
import service.CustomerServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

    CustomerServiceImpl customerService = new CustomerServiceImpl();

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

    private void clearTxtFields(){

        txtName.clear();
        txtPhoneNo.clear();
        txtEmail.clear();

    }

    @FXML
    void btnAddCusOnAction(ActionEvent event) {
        String cusId = lblCusID.getText();
        String name = txtName.getText();
        String phoneNo = txtPhoneNo.getText();
        String email = txtEmail.getText();

        CustomerDTO customerDTO = new CustomerDTO(cusId,name,phoneNo,email);

        customerService.addCustomer(customerDTO);

        setNewID();
        clearTxtFields();
        loadCustomers();

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
