package repository;

import db.DBConnection;
import model.entity.Return;
import repository.impl.RentalRepository;
import repository.impl.ReturnRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void addReturn(Return aReturn) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "INSERT INTO returns VALUES (?, ?, ?, ?, ?, ?, ?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setObject(1,aReturn.getId());
        preparedStatement.setObject(2,aReturn.getBookId());
        preparedStatement.setObject(3,aReturn.getCustomerId());
        preparedStatement.setObject(4,aReturn.getIssueDate());
        preparedStatement.setObject(5,aReturn.getDueDate());
        preparedStatement.setObject(6,aReturn.getOverdueDays());
        preparedStatement.setObject(7,aReturn.getFine());

        preparedStatement.executeUpdate();

    }

    public List<Return> getAllReturns() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM returns";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Return> returns = new ArrayList<>();

        while (resultSet.next()){
            returns.add(new Return(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getDouble(7)
            ));
        }
        return returns;
    }




}
