package DAO;

import conn.ConnDB;
import model.Linha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class LinhaDAO {

    private final String SELECT_BY_ID;

    {
        SELECT_BY_ID = "SELECT ID,ORIGEM,DESTINO,HORA_EMBARQUE,HORA_PARTIDA FROM linha WHERE ID=?";
    }

    public Linha getLineById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Linha linha = new Linha();

        try {
            connection = ConnDB.getInstance();
            if (connection == null) {
                System.out.println("Falha na conexão");
                return linha;
            }

            preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                linha = new Linha(rs.getInt("ID"), rs.getString("ORIGEM"),
                        rs.getString("DESTINO"), rs.getObject(4, LocalTime.class),
                        rs.getObject(5, LocalTime.class));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnDB.CloseResultSet(rs);
            ConnDB.CLosePreparedStatement(preparedStatement);
            ConnDB.CloseConn(connection);
        }

        return linha;
    }
}
