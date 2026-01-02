package contoller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class CustomerCardController {

    private CustomerInfoController customerInfoController;

    public void setCustomerInfoController(CustomerInfoController controller) {
        this.customerInfoController = controller;
    }

    @FXML
    private ImageView imgCustomer;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblName;

    public void setCustomerData(String title, String name, String phone) {

        if ( title.equals("Mr") ){
            Image image = new Image( getClass().getResourceAsStream("/img/Mr.Customer.png"));
            imgCustomer.setImage(image);
        } else if (title.equals("Mrs") ) {
            Image image = new Image(getClass().getResourceAsStream("/img/Mrs.Customer.png"));
            imgCustomer.setImage(image);
        }

        lblName.setText(name);
        lblContact.setText(phone);

    }

    @FXML
    void customerCardOnAction(MouseEvent event) {

        String phoneNo = lblContact.getText();
        customerInfoController.loadSelectedCustomer(phoneNo);

    }

}
