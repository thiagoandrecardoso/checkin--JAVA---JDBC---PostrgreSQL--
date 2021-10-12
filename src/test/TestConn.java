package test;

import DAO.BilheteDAO;
import model.Bilhete;

public class TestConn {

    public static void main(String[] args) {
        Bilhete bilhete = new Bilhete();

        BilheteDAO bilheteDAO = new BilheteDAO();
        bilhete = bilheteDAO.getTicketByCode("DRYMOD");

        bilheteDAO.uodateByCode(bilhete, "21");
    }
}
