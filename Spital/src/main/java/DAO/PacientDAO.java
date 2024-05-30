package DAO;

import Persoana.Pacient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacientDAO extends AbstractDAO<Pacient> {

    @Override
    protected String getTableName() {
        return "Pacient";
    }

    @Override
    protected Pacient mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Pacient pacient = new Pacient();
        pacient.setId(resultSet.getInt("id"));
        pacient.setNume(resultSet.getString("nume"));
        pacient.setPrenume(resultSet.getString("prenume"));
        pacient.setDataNasterii(resultSet.getString("dataNasterii"));
        pacient.setTelefon(resultSet.getString("telefon"));
        pacient.setAdresa(resultSet.getString("adresa"));
        return pacient;
    }

    @Override
    protected void setStatementParams(PreparedStatement statement, Pacient entity) throws SQLException {
        statement.setString(1, entity.getNume());
        statement.setString(2, entity.getPrenume());
        statement.setString(3, entity.getDataNasterii());
        statement.setString(4, entity.getTelefon());
        statement.setString(5, entity.getAdresa());
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Pacient (nume, prenume, dataNasterii, telefon, adresa) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Pacient SET nume = ?, prenume = ?, dataNasterii = ?, telefon = ?, adresa = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Pacient WHERE id = ?";
    }

    @Override
    protected void setIdAfterInsert(Pacient entity, int id) {
        entity.setId(id);
    }
}

