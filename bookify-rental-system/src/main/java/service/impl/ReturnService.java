package service.impl;

import model.dto.ReturnDTO;
import model.entity.Return;

import java.sql.SQLException;
import java.util.List;

public interface ReturnService {

    public String getLastReturnId();
    void addReturn(ReturnDTO returnDTO);
    public List<ReturnDTO> getAllReturns();
}
