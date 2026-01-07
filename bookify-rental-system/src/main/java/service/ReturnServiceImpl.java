package service;

import model.dto.ReturnDTO;
import model.entity.Return;
import repository.ReturnRepositoryImpl;
import repository.impl.ReturnRepository;
import service.impl.ReturnService;

import java.sql.SQLException;

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


}
