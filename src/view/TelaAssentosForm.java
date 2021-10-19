package view;

import model.Bilhete;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class TelaAssentosForm extends JFrame {
    protected Bilhete bilhete;
    JButton[] buttons = new JButton[40];
    protected JPanel jpAssento;
    protected JPanel jpCabechalho;
    protected JLabel jlAssento;

    public TelaAssentosForm(Bilhete bilhete) {
        this.bilhete = bilhete;
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Assentos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getCcabecalhoForm(), BorderLayout.PAGE_START);
        configuraArrayDeBotoes();
        this.getContentPane().add(getForm(), BorderLayout.CENTER);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        redenrizaAssentos();
        event();
    }

    protected abstract void selecionaAssento(ActionEvent ev);

    protected abstract void redenrizaAssentos();

    private void event() {
        for (JButton jButton : buttons) {
            jButton.addActionListener(this::selecionaAssento);
        }
    }

    public void configuraArrayDeBotoes() {
        for (int i = 0; i < 40; ++i) {
            buttons[i] = new JButton("" + (i + 1));
        }
    }

    public JPanel getCcabecalhoForm() {
        if (jpCabechalho == null) {
            jpCabechalho = new JPanel();
            jlAssento = new JLabel("Click para selecionar um Assento:");
            Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
            jlAssento.setBorder(border);
            jpCabechalho.add(jlAssento);
        }
        return jpCabechalho;
    }

    public JPanel getForm() {
        if (jpAssento == null) {
            jpAssento = new JPanel(new GridLayout(10, 4, 10, 10));
            for (int i = 0; i < 40; ++i) {
                buttons[i].setPreferredSize(new Dimension(50, 50));
                buttons[i].setContentAreaFilled(false);
                buttons[i].setOpaque(true);
                buttons[i].setBackground(Color.BLUE);
                jpAssento.add(buttons[i]);
            }
        }
        return jpAssento;
    }

}
