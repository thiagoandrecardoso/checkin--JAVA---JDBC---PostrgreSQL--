package test;

import DAO.LinhaDAO;
import model.Linha;

public class TestConn {

    public static void main(String[] args) {
        Linha linha = null;
        LinhaDAO linhaDAO = new LinhaDAO();

        linha = linhaDAO.getLineById(1);

        System.out.println(linha);
    }
}
