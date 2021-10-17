package view;

import model.Bilhete;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaInfoBilhete extends TelaInfoBilheteForm{
    public TelaInfoBilhete(Bilhete bilhete) {
        super(bilhete);
    }

    @Override
    public void btnProximo(ActionEvent e) {
        SwingUtilities.invokeLater(() ->{
            TelaAssento telaAssento = new TelaAssento();
            telaAssento.setVisible(true);
        });
    }
}
