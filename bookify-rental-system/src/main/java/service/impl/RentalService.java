package service.impl;

import model.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    void addRental(RentalDTO rentalDTO);
    String getLastRentalId();
    List<RentalDTO> getAllRentals();
    void updateRental(String rentalID, String bookID, String cusID);
    void deleteRental(String id);
    RentalDTO getRental(String id);
}
