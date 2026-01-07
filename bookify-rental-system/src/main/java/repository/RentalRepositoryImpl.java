package repository;

import db.DBConnection;
import model.entity.Rental;
import repository.impl.RentalRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalRepositoryImpl implements RentalRepository {

//----------------------Get Last Rental ID----------------------//
    public String getLastRentalId() throws SQLException {

        String lastId = null;

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "SELECT id FROM rentals ORDER BY id DESC LIMIT 1";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getString(1);
        }

        return lastId;
    }

//----------------------Add Rental----------------------//
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

//----------------------Get All Rentals----------------------//
    public List<Rental> getAllRentals() throws SQLException {

        List<Rental> rentals = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "Select * From rentals";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            rentals.add(new Rental(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return rentals;
    }

//----------------------Update Rental----------------------//
    public void updateRental(String rentalID, String bookID, String cusID) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String SQL = "UPDATE rentals SET book_id = ?, customer_id = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,bookID);
        preparedStatement.setObject(2,cusID);
        preparedStatement.setObject(3,rentalID);

        preparedStatement.executeUpdate();

    }

    //----------------------Delete Rental----------------------//
    public void deleteRental(String id) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "DELETE FROM rentals WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,id);

        preparedStatement.executeUpdate();


    }

    @Override
    public Rental getRental(String id) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM rentals WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            return new Rental(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return null;
    }


}
