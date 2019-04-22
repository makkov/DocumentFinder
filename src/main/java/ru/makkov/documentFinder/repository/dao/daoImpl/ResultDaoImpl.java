package ru.makkov.documentFinder.repository.dao.daoImpl;

import org.apache.log4j.Logger;
import ru.makkov.documentFinder.pojo.Result;
import ru.makkov.documentFinder.repository.connectionManager.ConnectionManager;
import ru.makkov.documentFinder.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.makkov.documentFinder.repository.dao.ResultDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultDaoImpl implements ResultDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    final static Logger LOGGER = Logger.getLogger(ResultDao.class);

    @Override
    public boolean addResult(Result result, Integer number) {
        LOGGER.info("Connection to the database\n");
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO result VALUES (DEFAULT, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, result.getCode());
            preparedStatement.setInt(2, number);
            preparedStatement.setString(3, result.getFileNames().toString().replaceAll("^\\[|\\]$", ""));
            preparedStatement.setString(4, result.getError());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + " Error writing the result to the database\n");
            return false;
        }
        return true;
    }
}
