package control;

import model.Bilhete;
import view.TelaInfoBilheteForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaInfoBilhete extends TelaInfoBilheteForm {
    public TelaInfoBilhete(Bilhete bilhete) {
        super(bilhete);
    }

    @Override
    public void btnProximo(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            TelaAssento telaAssento = new TelaAssento(bilhete);
            this.dispose();
            telaAssento.setVisible(true);
        });
    }

    @Override
    public void editPassageiro(ActionEvent ev) {
    }
}
