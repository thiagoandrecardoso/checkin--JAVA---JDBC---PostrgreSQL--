package DAO;

import conn.ConnDB;
import model.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassageiroDAO {
    private final String SELECT_BY_ID;
    private final String UDPATE_PASSAGEIRO;

    {
        SELECT_BY_ID = "SELECT ID,NOME,CPF,TELEFONE_CONTATO,EMAIL FROM PASSAGEIRO WHERE ID=?";
    }

    {
        UDPATE_PASSAGEIRO = "UPDATE passageiro SET nome = ?, cpf = ?, telefone_contato = ?, email =? where id = ?";
    }

    public boolean update(String nome, String cpf, String telefone, String email, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean updateOk = false;
        try {
            connection = ConnDB.getInstance();
            if (connection == null) {
                System.out.println("Falha na conexão!");
                return false;
            }
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(UDPATE_PASSAGEIRO);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, telefone);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            connection.commit();
            updateOk = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnDB.CLosePreparedStatement(preparedStatement);
            ConnDB.CloseConn(connection);
        }
        return updateOk;
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
