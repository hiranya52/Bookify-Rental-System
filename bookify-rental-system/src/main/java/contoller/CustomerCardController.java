package contoller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CustomerCardController {

    @FXML
    private ImageView imgCustomer;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblName;

    public void setCustomerData(String title, String name, String phone) {

        lblName.setText(name);
        lblContact.setText(phone);

    }

}
