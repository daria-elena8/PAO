package Database.DAO;

import Database.config.DatabaseConfiguration;
import Persoana.Pacient;
import Persoana.Fisa_Medicala.*;
import java.sql.*;
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
        pacient.setDataNasterii(resultSet.getString("data_nasterii"));
        pacient.setTelefon(resultSet.getString("telefon"));
        pacient.setAdresa(resultSet.getString("adresa"));
        return pacient;
    }

    @Override
    protected void setStatementParams(PreparedStatement statement, Pacient entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getNume());
        statement.setString(3, entity.getPrenume());
        statement.setString(4, entity.getDataNasterii());
        statement.setString(5, entity.getTelefon());
        statement.setString(6, entity.getAdresa());
    }

    @Override
    protected String create() {
        return "INSERT INTO Pacient (id, nume, prenume, data_nasterii, telefon, adresa) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setIdAfterInsert(Pacient entity, int id) {
        entity.setId(id);
    }

    @Override
    protected String update() {
        return "UPDATE Pacient SET nume = ?, prenume = ?, data_nasterii = ?, telefon = ?, adresa = ? WHERE id = ?";
    }

    public Pacient read(int id) {
        String query = "SELECT * FROM pacienti WHERE id = ?";
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

    public void delete(int id) {
        String query = "DELETE FROM pacienti WHERE id = ?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createWithFisa(Pacient pacient, FisaMedicala fisa) {
        FisaMedicalaDAO fisaDAO = new FisaMedicalaDAO();
        fisaDAO.create(fisa);
        pacient.setId(fisa.getId());
        create(pacient);
    }
}
