package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class TelaAssentosForm extends JFrame {
    private final List<JButton> jButtonList = new ArrayList<>();
    protected JPanel jpAssento;
    protected JPanel jpCabechalho;
    protected JLabel jlAssento;
    protected JButton jbAssento01;
    protected JButton jbAssento02;
    protected JButton jbAssento03;
    protected JButton jbAssento04;
    protected JButton jbAssento05;
    protected JButton jbAssento06;
    protected JButton jbAssento07;
    protected JButton jbAssento08;

    public TelaAssentosForm() {
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Assentos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getCcabecalhoForm(), BorderLayout.PAGE_START);
        this.getContentPane().add(getForm(), BorderLayout.CENTER);
        this.setResizable(false);
        this.pack();
        configuraArrayDeBotoes();
        event();
    }

    protected abstract void selecionaAssento(ActionEvent ev);

    private void event() {
        jbAssento01.addActionListener(this::selecionaAssento);
        jbAssento02.addActionListener(this::selecionaAssento);
        jbAssento03.addActionListener(this::selecionaAssento);
        jbAssento04.addActionListener(this::selecionaAssento);
        jbAssento05.addActionListener(this::selecionaAssento);
        jbAssento06.addActionListener(this::selecionaAssento);
        jbAssento07.addActionListener(this::selecionaAssento);
        jbAssento08.addActionListener(this::selecionaAssento);
    }

    public void configuraArrayDeBotoes() {
        jButtonList.add(jbAssento01);
        jButtonList.add(jbAssento02);
        jButtonList.add(jbAssento03);
        jButtonList.add(jbAssento04);
        jButtonList.add(jbAssento05);
        jButtonList.add(jbAssento06);
        jButtonList.add(jbAssento07);
        jButtonList.add(jbAssento08);
    }

    public JPanel getCcabecalhoForm(){
        if (jpCabechalho == null){
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
            jpAssento = new JPanel(new GridLayout(4, 2, 15, 15));

            jbAssento01 = new JButton("01");
            jbAssento01.setPreferredSize(new Dimension(80, 80));
            jbAssento02 = new JButton("02");
            jbAssento02.setPreferredSize(new Dimension(80, 80));
            jbAssento03 = new JButton("03");
            jbAssento03.setPreferredSize(new Dimension(80, 80));
            jbAssento04 = new JButton("04");
            jbAssento04.setPreferredSize(new Dimension(80, 80));
            jbAssento05 = new JButton("05");
            jbAssento05.setPreferredSize(new Dimension(80, 80));
            jbAssento06 = new JButton("06");
            jbAssento06.setPreferredSize(new Dimension(80, 80));
            jbAssento07 = new JButton("07");
            jbAssento07.setPreferredSize(new Dimension(80, 80));
            jbAssento08 = new JButton("08");
            jbAssento08.setPreferredSize(new Dimension(80, 80));

            jpAssento.add(jbAssento01);
            jpAssento.add(jbAssento02);
            jpAssento.add(jbAssento03);
            jpAssento.add(jbAssento04);
            jpAssento.add(jbAssento05);
            jpAssento.add(jbAssento06);
            jpAssento.add(jbAssento07);
            jpAssento.add(jbAssento08);
        }
        return jpAssento;
    }

}
