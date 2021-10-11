package test;

import DAO.BilheteDAO;
import DAO.PassageiroDAO;
import model.Bilhete;
import model.Passageiro;

public class TestConn {

    public static void main(String[] args) {
        Bilhete bilhete = new Bilhete();

        BilheteDAO bilheteDAO = new BilheteDAO();
        bilhete = bilheteDAO.getTicketByCode("DRYMOD");

        bilheteDAO.uodateByCode(bilhete, "21");
    }
}
