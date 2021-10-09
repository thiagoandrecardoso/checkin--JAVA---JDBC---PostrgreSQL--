package DAO;

import conn.ConnDB;
import model.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassageiroDAO {
    private final String SELECT_BY_ID;

    {
        SELECT_BY_ID = "SELECT ID,NOME,CPF,TELEFONE_CONTATO,EMAIL FROM PASSAGEIRO WHERE ID=?";
    }

    public Passageiro getPassengerById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Passageiro passageiro = new Passageiro();

        try {
            connection = ConnDB.getInstance();
            if (connection == null) {
                System.out.println("Falha na conexão");
                return passageiro;
            }
            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                passageiro = new Passageiro(rs.getInt("ID"), rs.getString("NOME"),
                        rs.getString("CPF"), rs.getString("TELEFONE_CONTATO"),
                        rs.getString("EMAIL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnDB.CloseResultSet(rs);
            ConnDB.CLosePreparedStatement(preparedStatement);
            ConnDB.CloseConn(connection);
        }

        return passageiro;
    }
}
