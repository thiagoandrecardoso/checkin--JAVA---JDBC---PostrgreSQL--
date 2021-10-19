package DAO;

import conn.ConnDB;
import model.Bilhete;
import model.Linha;
import model.Passageiro;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BilheteDAO {
    private final String SELECT_BY_CODE;
    private final String UPDATE_BY_CODE;
    private final String GET_LIST_BY_LINHA;

    {
        SELECT_BY_CODE = "SELECT CODIGO,ASSENTO,id_passageiro,id_linha,assento_marcado_em FROM bilhete WHERE CODIGO=?";
    }

    {
        UPDATE_BY_CODE = "UPDATE bilhete SET assento = ?, assento_marcado_em = ? WHERE codigo = ?";
    }

    {
        GET_LIST_BY_LINHA = "SELECT ASSENTO FROM bilhete WHERE id_linha = ?";
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
                bilhete = new Bilhete(rs.getString("CODIGO"), rs.getInt("ASSENTO"),
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

    public void uodateByCode(Bilhete bilhete, int assento) {
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
            preparedStatement.setInt(1, assento);
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

    public List<String> getAssentoByLinha(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<String> assentosList = new ArrayList<>();

        try {
            connection = ConnDB.getInstance();
            if (connection == null){
                System.out.println("Falha na conexão");
                return assentosList;
            }
            preparedStatement = connection.prepareStatement(GET_LIST_BY_LINHA);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                if (rs.getString("ASSENTO") != null){
                    assentosList.add(rs.getString("ASSENTO"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnDB.CloseResultSet(rs);
            ConnDB.CLosePreparedStatement(preparedStatement);
            ConnDB.CloseConn(connection);
        }

        return assentosList;
    }
}
