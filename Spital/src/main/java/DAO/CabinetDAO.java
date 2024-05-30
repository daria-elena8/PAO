package DAO;

import Cabinete.Cabinet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CabinetDAO extends AbstractDAO<Cabinet> {

    @Override
    protected String getTableName() {
        return "Cabinet";
    }


    @Override
    protected Cabinet mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Cabinet cabinet = new Cabinet();
        cabinet.setIdCabinet(resultSet.getInt("id"));
        cabinet.setEtaj(resultSet.getInt("etaj"));
        cabinet.setOrar(resultSet.getString("orar"));
        cabinet.setIdMedic(resultSet.getInt("idMedic"));
        cabinet.setIdAsistent(resultSet.getInt("idAsistent"));
        return cabinet;
    }

    @Override
    protected void setStatementParams(PreparedStatement statement, Cabinet entity) throws SQLException {
        statement.setInt(1, entity.getEtaj());
        statement.setString(2, entity.getOrar());
        statement.setInt(3, entity.getIdMedic());
        statement.setInt(4, entity.getIdAsistent());
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Cabinet (etaj, orar, idMedic, idAsistent) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Cabinet SET etaj = ?, orar = ?, idMedic = ?, idAsistent = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Cabinet WHERE id = ?";
    }

    @Override
    protected void setIdAfterInsert(Cabinet entity, int id) {
        entity.setIdCabinet(id);
    }
}
