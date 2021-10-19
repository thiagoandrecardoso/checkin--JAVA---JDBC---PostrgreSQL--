package view;

import DAO.BilheteDAO;
import model.Bilhete;

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
    protected void selecionaAssento(ActionEvent ev) {
        numeroAssento = Integer.parseInt(ev.getActionCommand());
    }

    @Override
    protected void redenrizaAssentos() {
        BilheteDAO bilheteDAO = new BilheteDAO();
        int linha_id = bilhete.getLinha().getId();
        List<String> assentoList = bilheteDAO.getAssentoByLinha(linha_id);

        for(String s : assentoList){
            for(JButton jb : buttons){
                if (jb.getText().equals(s)){
                    jb.setBackground(Color.RED);
                    jb.setText(jb.getText());
                    jb.setEnabled(false);
                }
            }
        }
    }
}
