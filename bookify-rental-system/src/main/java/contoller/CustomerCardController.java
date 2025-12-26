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

}
