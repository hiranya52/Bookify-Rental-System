package service.impl;

import model.dto.ReturnDTO;

import java.sql.SQLException;

public interface ReturnService {

    public String getLastReturnId();
    void addReturn(ReturnDTO returnDTO);
}
