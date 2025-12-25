package contoller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class UserCardController {

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblName;

    public void setUserData(String name, String phone) {
        lblName.setText(name);
        lblContact.setText(phone);
    }

}
