package contoller;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.dto.CustomerDTO;
import model.dto.UserDTO;
import service.CustomerServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {

    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @FXML
    private JFXComboBox<String> cmbTitle;

    @FXML
    private GridPane customerContainer;

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
    void btnAddCustomerOnAction(ActionEvent event) {

        String cusId = lblCusID.getText();
        String title = cmbTitle.getSelectionModel().getSelectedItem();
        String name = txtName.getText();
        String phoneNo = txtPhoneNo.getText();
        String email = txtEmail.getText();

        CustomerDTO customerDTO = new CustomerDTO(cusId, title, name, phoneNo, email);
        customerService.addCustomer(customerDTO);

        loadCustomers();
        setNewID();
        clearTxtFields();

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
    void btnDeleteCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login_form.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource())
                    .getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearTxtFields() {
        cmbTitle.setValue(null);
        txtName.clear();
        txtPhoneNo.clear();
        txtEmail.clear();
    }

    public void setNewID() {

        String newId = "";
        String lastCusId = customerService.getLastCustomerId();

        if (lastCusId == null) {
            newId = "C001";
        } else {
            int numericPart = Integer.parseInt(lastCusId.substring(1));
            numericPart++;
            newId = String.format("C%03d", numericPart);
        }

        lblCusID.setText(newId);
    }

    private void loadCustomers(){

        customerContainer.getChildren().clear();

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        for (CustomerDTO customerDTO : customerDTOS){

            try {
                FXMLLoader loader = new FXMLLoader( getClass().getResource("/view/customer_card.fxml") );

                AnchorPane card = loader.load();

                CustomerCardController controller = loader.getController();
                controller.setCustomerData(customerDTO.getTitle(),customerDTO.getName(),customerDTO.getPhoneNo());

                int totalCards = customerContainer.getChildren().size();

                int column = totalCards % 3;   // 0,1,2
                int row = totalCards / 3;      // auto increases

                customerContainer.add(card, column, row);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setNewID();

        cmbTitle.getItems().addAll("Mr", "Mrs");

        loadCustomers();

    }
}
