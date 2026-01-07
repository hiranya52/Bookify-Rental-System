package repository;

import db.DBConnection;
import repository.impl.RentalRepository;
import repository.impl.ReturnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReturnRepositoryImpl implements ReturnRepository {

    //----------------------Get Last Customer ID----------------------//
    public String getLastReturnId() throws SQLException {

        String lastId = null;
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT id FROM returns ORDER BY id DESC LIMIT 1";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            lastId = resultSet.getString(1);
        }
        return lastId;
    }



}
