package repository.impl;

import model.entity.Rental;

import java.sql.SQLException;
import java.util.List;

public interface RentalRepository {

    public String getLastRentalId() throws SQLException;
    public void addRental(Rental rental) throws SQLException;
    public List<Rental> getAllRentals() throws SQLException;
    public void updateRental(String rentalID, String bookID, String cusID) throws SQLException;
    public void deleteRental(String id) throws SQLException;

}
