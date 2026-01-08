package repository.impl;

import model.entity.Return;

import java.sql.SQLException;
import java.util.List;

public interface ReturnRepository {

    public String getLastReturnId() throws SQLException;
    void addReturn(Return aReturn) throws SQLException;
    public List<Return> getAllReturns() throws SQLException;

}
