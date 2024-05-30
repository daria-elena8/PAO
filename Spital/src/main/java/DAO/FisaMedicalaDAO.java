package DAO;

import Persoana.Fisa_Medicala.Diagnostic;
import Persoana.Fisa_Medicala.FisaMedicala;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FisaMedicalaDAO extends AbstractDAO<FisaMedicala> {

    @Override
    protected String getTableName() {
        return "FisaMedicala";
    }

    @Override
    protected FisaMedicala mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        FisaMedicala fisa = new FisaMedicala();
        fisa.setNrFisa(resultSet.getInt("id"));
        fisa.setIdPacient(resultSet.getInt("pacient_id"));
        String diagnosticeStr = resultSet.getString("diagnostice");

        List<Diagnostic> diagnostice = Arrays.stream(diagnosticeStr.split(","))
                .map(Diagnostic::valueOf)
                .collect(Collectors.toList());
        fisa.setDiagnostice(diagnostice);
        return fisa;
    }

    protected void setStatementParams(PreparedStatement statement, FisaMedicala entity) throws SQLException {
        statement.setInt(1, entity.getIdPacient());
        String diagnosticeStr = entity.getDiagnostice().stream()
                .map(Diagnostic::name)
                .collect(Collectors.joining(","));
        statement.setString(2, diagnosticeStr);
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO FisaMedicala (pacient_id, diagnostice) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE FisaMedicala SET pacient_id = ?, diagnostice = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM FisaMedicala WHERE id = ?";
    }

    @Override
    protected void setIdAfterInsert(FisaMedicala entity, int id) {
        entity.setNrFisa(id);
    }
}
