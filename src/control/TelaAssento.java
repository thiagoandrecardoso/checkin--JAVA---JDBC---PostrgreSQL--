package control;

import DAO.BilheteDAO;
import model.Bilhete;
import view.TelaAssentosForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TelaAssento extends TelaAssentosForm {

    private int numeroAssento;

    public TelaAssento(Bilhete bilhete) {
        super(bilhete);
    }

    @Override
    public void selecionaAssento(ActionEvent ev) {
        numeroAssento = Integer.parseInt(ev.getActionCommand());
        renderizaDepoisQueSeleciona();
        buttons[numeroAssento - 1].setBackground(Color.GREEN);
    }

    @Override
    public void proximo(ActionEvent ev) {
        BilheteDAO bilheteDAO = new BilheteDAO();
        bilheteDAO.uodateByCode(bilhete, numeroAssento);
        JOptionPane.showMessageDialog(null, "Checkin realizado com sucesso!");
        this.dispose();
    }

    private void renderizaDepoisQueSeleciona() {
        for (int i = 0; i < 40; ++i) {
            if (buttons[i].isEnabled()) {
                buttons[i].setBackground(Color.BLUE);
            }
        }
    }

    @Override
    public void redenrizaAssentos() {
        BilheteDAO bilheteDAO = new BilheteDAO();
        int linha_id = bilhete.getLinha().getId();
        List<String> assentoList = bilheteDAO.getAssentoByLinha(linha_id);

        for (String s : assentoList) {
            for (JButton jb : buttons) {
                if (jb.getText().equals(s)) {
                    jb.setBackground(Color.RED);
                    jb.setText(jb.getText());
                    jb.setEnabled(false);
                }
            }
        }
    }
}
