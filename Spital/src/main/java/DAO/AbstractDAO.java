package DAO;

import Database.config.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> {

    protected abstract String getTableName();

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract void setStatementParams(PreparedStatement statement, T entity) throws SQLException;

    protected abstract String getInsertQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteQuery();

    protected abstract void setIdAfterInsert(T entity, int id);

    public void create(T entity) {
        String query = getInsertQuery();
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            setStatementParams(statement, entity);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                setIdAfterInsert(entity, keys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T read(int id) {
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> readAll() {
        List<T> entities = new ArrayList<>();
        String query = "SELECT * FROM " + getTableName();
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public void update(T entity) {
        String query = getUpdateQuery();
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            setStatementParams(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = getDeleteQuery();
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
