package service;

import model.dto.RentalDTO;
import model.entity.Rental;
import repository.RentalRepositoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalServiceImpl {

    RentalRepositoryImpl rentalRepository = new RentalRepositoryImpl();

//----------------------Add Rental----------------------//
    public void addRental(RentalDTO rentalDTO) {

        Rental rental = new Rental(
                rentalDTO.getId(),
                rentalDTO.getBookId(),
                rentalDTO.getCustomerId(),
                rentalDTO.getIssueDate(),
                rentalDTO.getDueDate()
        );

        try {
            rentalRepository.addRental(rental);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//----------------------Get Last Rentals----------------------//
    public String getLastRentalId() {

        try {
            return rentalRepository.getLastRentalId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//----------------------Get All Rentals----------------------//
    public List<RentalDTO> getAllRentals() {

        List<RentalDTO> rentalDTOS = new ArrayList<>();

        try {
            List<Rental> rentals = rentalRepository.getAllRentals();
            for (Rental rental : rentals){
                rentalDTOS.add(new RentalDTO(
                        rental.getId(),
                        rental.getBookId(),
                        rental.getCustomerId(),
                        rental.getIssueDate(),
                        rental.getDueDate()
                ));
            }
            return rentalDTOS;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//----------------------Update Rental----------------------//
    public void updateRental(String rentalID, String bookID, String cusID) {

        try {
            rentalRepository.updateRental(rentalID,bookID,cusID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
