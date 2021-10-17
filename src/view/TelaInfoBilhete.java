package view;

import model.Bilhete;

import java.awt.event.ActionEvent;

public class TelaInfoBilhete extends TelaInfoBilheteForm{
    public TelaInfoBilhete(Bilhete bilhete) {
        super(bilhete);
    }

    @Override
    public void btnProximo(ActionEvent e) {
        // TODO chamar tela de assentos.
    }
}
