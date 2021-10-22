package control;

import DAO.PassageiroDAO;
import model.Bilhete;
import view.TelaEditaPassageiroForm;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaEditaPassageiro extends TelaEditaPassageiroForm {
    public TelaEditaPassageiro(Bilhete bilhete) {
        super(bilhete);
    }

    @Override
    public void salvar(ActionEvent ev) {
        PassageiroDAO passageiroDAO = new PassageiroDAO();
        boolean updateOK = passageiroDAO.update(txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), txtEmail.getText(), bilhete.getPassageiro().getId());
        if(updateOK) JOptionPane.showMessageDialog(null, "Passageiro editado com sucesso!");


    }

}
