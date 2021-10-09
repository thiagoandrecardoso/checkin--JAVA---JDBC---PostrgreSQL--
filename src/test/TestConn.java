package test;

import DAO.PassageiroDAO;
import model.Passageiro;

public class TestConn {

    public static void main(String[] args) {
        Passageiro passageiro = new Passageiro();
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        passageiro = passageiroDAO.getPassengerById(51);
        System.out.println(passageiro);
    }
}
