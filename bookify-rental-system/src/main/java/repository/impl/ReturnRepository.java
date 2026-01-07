package repository.impl;

import model.entity.Return;

import java.sql.SQLException;

public interface ReturnRepository {

    public String getLastReturnId() throws SQLException;
    void addReturn(Return aReturn) throws SQLException;

}
