package service;

import model.dto.RentalDTO;
import model.entity.Rental;
import repository.RentalRepositoryImpl;

import java.sql.SQLException;

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



}
