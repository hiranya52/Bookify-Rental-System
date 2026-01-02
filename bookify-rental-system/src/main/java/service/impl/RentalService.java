package service.impl;

import model.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    public void addRental(RentalDTO rentalDTO);
    public String getLastRentalId();
    public List<RentalDTO> getAllRentals();
    public void updateRental(String rentalID, String bookID, String cusID);
    public void deleteRental(String id);

}
