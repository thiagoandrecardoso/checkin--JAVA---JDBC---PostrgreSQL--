package view;

import model.Bilhete;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class TelaAssentosForm extends JFrame {
    public Bilhete bilhete;
    public JButton[] buttons = new JButton[40];
    public JPanel jpAssento;
    public JPanel jpCabechalho;
    public JLabel jlAssento;
    public JPanel jpButton;
    public JButton jbProximo;

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
        this.getContentPane().add(getJpButtonForm(), BorderLayout.PAGE_END);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        redenrizaAssentos();
        event();
    }

    public abstract void selecionaAssento(ActionEvent ev);

    public abstract void proximo(ActionEvent ev);

    public abstract void redenrizaAssentos();

    private void event() {
        for (int i = 0; i < 40; ++i) {
            buttons[i].addActionListener(this::selecionaAssento);
        }
        jbProximo.addActionListener(this::proximo);
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

    public JPanel getJpButtonForm() {
        if (jpButton == null) {
            jpButton = new JPanel();
            jbProximo = new JButton("Próximo");
            jpButton.add(jbProximo);
        }
        return jpButton;
    }

}
