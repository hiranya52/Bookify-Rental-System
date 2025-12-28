package repository;

import db.DBConnection;
import model.entity.Rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalRepositoryImpl {


    public void addRental(Rental rental) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "INSERT INTO rentals VALUES (?, ?, ?, ?, ?) ";

        PreparedStatement  preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,rental.getId());
        preparedStatement.setObject(2,rental.getBookId());
        preparedStatement.setObject(3,rental.getCustomerId());
        preparedStatement.setObject(4,rental.getIssueDate());
        preparedStatement.setObject(5,rental.getDueDate());

        preparedStatement.executeUpdate();

    }


}
