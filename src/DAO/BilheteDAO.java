package DAO;

import conn.ConnDB;
import model.Bilhete;
import model.Linha;
import model.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BilheteDAO {
    private final String SELECT_BY_CODE;

    {
        SELECT_BY_CODE = "SELECT CODIGO,ASSENTO,id_passageiro,id_linha,assento_marcado_em FROM bilhete WHERE CODIGO=?";
    }

    private final String UPDATE_BY_CODE;

    {
        UPDATE_BY_CODE = "UPDATE bilhete SET assento = ?, assento_marcado_em = ? WHERE codigo = ?";
    }

    public Bilhete getTicketByCode(String code) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Bilhete bilhete = new Bilhete();

        try {
            connection = ConnDB.getInstance();
            if (connection == null) {
                System.out.println("Falha na conexão");
                return bilhete;
            }
            preparedStatement = connection.prepareStatement(SELECT_BY_CODE);
            preparedStatement.setString(1, code);
            rs = preparedStatement.executeQuery();
            PassageiroDAO passageiroDAO = new PassageiroDAO();
            LinhaDAO linhaDAO = new LinhaDAO();
            while (rs.next()) {
                Passageiro passageiro = passageiroDAO.getPassengerById(rs.getInt("id_passageiro"));
                Linha linha = linhaDAO.getLineById(rs.getInt("id_linha"));
                bilhete = new Bilhete(rs.getString("CODIGO"), rs.getString("ASSENTO"),
                        passageiro, linha,
                        rs.getObject(5, LocalDateTime.class));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnDB.CloseResultSet(rs);
            ConnDB.CLosePreparedStatement(preparedStatement);
            ConnDB.CloseConn(connection);
        }

        return bilhete;
    }

    public void uodateByCode(Bilhete bilhete, String assento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnDB.getInstance();
            if (connection == null) {
                System.out.println("Falha na conexão");
                return;
            }
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UPDATE_BY_CODE);
            preparedStatement.setString(1, assento);
            preparedStatement.setObject(2, LocalDateTime.now());
            preparedStatement.setString(3, bilhete.getCodigo());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnDB.CLosePreparedStatement(preparedStatement);
            ConnDB.CloseConn(connection);
        }
    }
}
