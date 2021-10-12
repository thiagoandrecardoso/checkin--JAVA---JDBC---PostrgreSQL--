package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class TelaInicialForm extends JFrame {
    protected JPanel jPanel;
    protected JButton btnChekin;

    public TelaInicialForm() {
        this.inicializar();
    }

    private void inicializar() {
        this.setTitle("Checkin");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getForm(), BorderLayout.CENTER);
        this.setResizable(false);
    }

    protected abstract void abrirTelaRealizarCHekin(ActionEvent ev);

    private void event() {
        btnChekin.addActionListener(this::abrirTelaRealizarCHekin);
    }


    public JPanel getForm() {
        if (jPanel == null) {
            jPanel = new JPanel(new GridLayout(1, 1));
            btnChekin = new JButton("Check In");
            jPanel.add(btnChekin);
        }
        return jPanel;
    }

}
