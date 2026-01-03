package contoller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

public class UserCardController {

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblName;

    private UserInfoController userInfoController;

    public void setUserInfoController(UserInfoController userInfoController){
        this.userInfoController=userInfoController;
    }

    public void setUserData(String title, String name, String role, String phone) {

        if ( title.equals("Mr") && role.equals("Admin") ){
            Image image = new Image( getClass().getResourceAsStream("/img/Mr.Admin.png"));
            imgUser.setImage(image);
        } else if (title.equals("Mrs") && role.equals("Admin") ) {
            Image image = new Image( getClass().getResourceAsStream("/img/Mrs.Admin.png"));
            imgUser.setImage(image);
        }else if ( title.equals("Mr") && role.equals("Staff") ){
            Image image = new Image( getClass().getResourceAsStream("/img/Mr.Staff.png"));
            imgUser.setImage(image);
        }else if ( title.equals("Mrs") && role.equals("Staff") ){
            Image image = new Image( getClass().getResourceAsStream("/img/Mrs.Staff.png"));
            imgUser.setImage(image);
        }

        lblName.setText(name);
        lblContact.setText(phone);
    }

    @FXML
    void userCardOnAction(MouseEvent event) {
        userInfoController.loadSelectedUser(lblContact.getText());
    }


}
