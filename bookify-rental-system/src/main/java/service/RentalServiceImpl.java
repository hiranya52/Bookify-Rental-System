package service;

import model.dto.RentalDTO;
import model.entity.Rental;
import repository.RentalRepositoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalServiceImpl {

    RentalRepositoryImpl rentalRepository = new RentalRepositoryImpl();

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


    public String getLastRentalId() {

        try {
            return rentalRepository.getLastRentalId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


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




}
