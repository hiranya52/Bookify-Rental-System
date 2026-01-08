package service;

import model.dto.ReturnDTO;
import model.entity.Return;
import repository.ReturnRepositoryImpl;
import repository.impl.ReturnRepository;
import service.impl.ReturnService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnServiceImpl implements ReturnService {

    ReturnRepository returnRepository = new ReturnRepositoryImpl();

    @Override
    public String getLastReturnId() {
        try {
            return returnRepository.getLastReturnId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addReturn(ReturnDTO returnDTO) {

        try {
            Return aReturn = new Return(
                    returnDTO.getId(),
                    returnDTO.getBookId(),
                    returnDTO.getCustomerId(),
                    returnDTO.getIssueDate(),
                    returnDTO.getDueDate(),
                    returnDTO.getOverdueDays(),
                    returnDTO.getFine()
            );

            returnRepository.addReturn(aReturn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<ReturnDTO> getAllReturns(){

        List<ReturnDTO> returnDTOS = new ArrayList<>();
        try {

            List<Return> returns = returnRepository.getAllReturns();

            for ( Return aReturn : returns ) {
                returnDTOS.add(new ReturnDTO(
                        aReturn.getId(),
                        aReturn.getBookId(),
                        aReturn.getCustomerId(),
                        aReturn.getIssueDate(),
                        aReturn.getDueDate(),
                        aReturn.getOverdueDays(),
                        aReturn.getFine()
                ));
            }

            return returnDTOS;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
