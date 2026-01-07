package service;

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

}
