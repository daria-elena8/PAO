package Database.DAO;
import Persoana.Pacient;
import Persoana.Fisa_Medicala.FisaMedicala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.config.DatabaseConfiguration;

public class FisaMedicalaDAO extends AbstractDAO<FisaMedicala> {

    @Override
    protected String getTableName() {
        return "FisaMedicala";
    }

    @Override
    protected FisaMedicala mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        FisaMedicala fisa = new FisaMedicala();
        fisa.setId(resultSet.getInt("id"));
        fisa.setDiagnostice(resultSet.getString("diagnostice"));

        // Citim datele pacientului folosind PacientDAO
        int pacientId = fisa.getId();
        PacientDAO pacientDAO = new PacientDAO();
        Pacient pacient = pacientDAO.read(pacientId);
        fisa.setPacient(pacient);

        return fisa;
    }

    @Override
    protected void setStatementParams(PreparedStatement statement, FisaMedicala entity) throws SQLException {
        statement.setString(2, entity.getDiagnostice());
    }

    @Override
    protected String create() {
        return "INSERT INTO FisaMedicala (alte_detalii, diagnostice) VALUES (?, ?)";
    }

    @Override
    protected void setIdAfterInsert(FisaMedicala entity, int id) {
        entity.setId(id);
    }

    @Override
    protected String update() {
        return "UPDATE FisaMedicala SET alte_detalii = ?, diagnostice = ? WHERE id = ?";
    }

    // Metoda read pentru a citi o fișă medicală după ID
    public FisaMedicala read(int id) {
        String query = "SELECT * FROM FisaMedicala WHERE id = ?";
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

    // Metoda delete pentru a șterge o fișă medicală după ID
    public void delete(int id) {
        String query = "DELETE FROM FisaMedicala WHERE id = ?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
