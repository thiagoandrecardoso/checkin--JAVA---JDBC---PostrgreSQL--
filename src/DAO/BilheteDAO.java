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
        SELECT_BY_CODE = "codigo,assento,id_passageiro,id_linha,assento_marcado_em FROM bilhete WHERE CODIGO=?";
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
            while (rs.next()) {
                bilhete = new Bilhete(rs.getString("CODIGO"), rs.getString("ASSENTO"),
                        rs.getObject(3, Passageiro.class), rs.getObject(4, Linha.class),
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
}
