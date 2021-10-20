package view;

import DAO.BilheteDAO;
import model.Bilhete;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaInicial extends TelaInicialForm {

    @Override
    protected void btnProximoLocalizaBilhete(ActionEvent ev) {
        String codigoBilhete = txtCheckin.getText();
        BilheteDAO bilheteDAO = new BilheteDAO();
        Bilhete bilhete = bilheteDAO.getTicketByCode(codigoBilhete);
        System.out.println(bilhete);

        SwingUtilities.invokeLater(() -> {
            TelaInfoBilhete telaInfoBilhete = new TelaInfoBilhete(bilhete);
            final JDialog frame = new JDialog(telaInfoBilhete, "Info Bilhete", true);
            frame.setSize(300, 250);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(telaInfoBilhete.getjPanelCAbecalhoForm(), BorderLayout.PAGE_START);
            frame.getContentPane().add(telaInfoBilhete.getBilheteForm(), BorderLayout.CENTER);
            frame.getContentPane().add(telaInfoBilhete.getPassageiroForm(), BorderLayout.PAGE_END);
            frame.setResizable(false);

            frame.setVisible(true);
        });


    }

    @Override
    protected void adicionarEscutaCheckBox() {
        cbCheckin.addItemListener(e -> {
            if (cbCheckin.isSelected()) {
                txtCheckin.setEditable(true);
                txtCheckin.setForeground(Color.red);
                txtCheckin.setBorder(new LineBorder(Color.red, 1));
                txtCheckin.setText("Informe o número do bilhete!");
            }
        });
    }

    @Override
    protected void adicionaEscutaTxtCheckin() {
        txtCheckin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtCheckin.getText().trim().equals("Informe o número do bilhete!")) {
                    txtCheckin.setBorder(new LineBorder(Color.green, 1));
                    txtCheckin.setText("");
                    txtCheckin.setForeground(Color.black);
                }
                super.focusGained(e);
            }
        });
    }
}
