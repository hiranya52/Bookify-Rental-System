package contoller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import model.dto.BookDTO;
import service.BookServiceImpl;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookInfoController implements Initializable {

    BookServiceImpl bookService = new BookServiceImpl();

    @FXML
    private Label lblAdministrator;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblDate;

    @FXML
    private Spinner<Integer> spnQty;

    @FXML
    private JFXTextField txtAuthor;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextField txtTitle;

    private void setDate(){

        LocalDate currentDate = LocalDate.now();
        lblDate.setText(String.valueOf(currentDate));

    }

//----------------------Add Books----------------------//
    @FXML
    void btnAddBookOnAction(ActionEvent event) {

        String id = lblBookID.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String category = txtCategory.getText();
        int quantity = spnQty.getValue();

        BookDTO bookDTO = new BookDTO(id, title, author, category, quantity);
        bookService.addBook(bookDTO);

        setNewID();
        cleartxtFields();
    }

//----------------------Delete Book----------------------//
    @FXML
    void btnDeleteBookOnAction(ActionEvent event) {

    }

//----------------------Update Book----------------------//
    @FXML
    void btnUpdateBookOnAction(ActionEvent event) {

    }

//----------------------Clear Text Fields----------------------//
    private void cleartxtFields() {
        txtTitle.clear();
        txtAuthor.clear();
        txtCategory.clear();
        spnQty.getValueFactory().setValue(1);
    }

//----------------------Set New ID----------------------//
    public void setNewID() {

        String lastBookID = bookService.getLastBookID();
        if (lastBookID == null) {
            lastBookID = "B001";
        }
        int numericPart = Integer.parseInt(lastBookID.substring(1));
        numericPart++;

        String newID = String.format("B%03d", numericPart);
        lblBookID.setText(newID);
    }


//----------------------Initialize----------------------//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);

        spnQty.setValueFactory(valueFactory);
        spnQty.setEditable(true);

        setDate();
        setNewID();
    }
}
