package view;

import DAO.BilheteDAO;
import model.Bilhete;

import java.awt.event.ActionEvent;

public class TelaInicial extends TelaInicialForm {

    @Override
    protected void btnProximoLocalizaBilhete(ActionEvent ev) {
        String codigoBilhete = txtCheckin.getText();
        BilheteDAO bilheteDAO = new BilheteDAO();
        Bilhete bilhete = bilheteDAO.getTicketByCode(codigoBilhete);
        System.out.println(bilhete);
    }

    @Override
    protected void adicionarEscutaCheckBox() {
        cbCheckin.addItemListener(e -> {
            if (cbCheckin.isSelected()) {
                txtCheckin.setEditable(true);
                txtCheckin.requestFocusInWindow();
            }
        });
    }
}
