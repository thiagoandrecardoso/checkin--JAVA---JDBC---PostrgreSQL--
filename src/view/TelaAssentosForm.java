package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class TelaAssentosForm extends JFrame {
    protected JPanel jpAssento;
    protected JLabel jlAssento;
    protected JButton jbAssento01;
    protected JButton jbAssento02;
    protected JButton jbAssento03;
    protected JButton jbAssento04;
    protected JButton jbAssento05;
    protected JButton jbAssento06;
    protected JButton jbAssento07;
    protected JButton jbAssento08;
    protected JSeparator jSeparator;
    private List<JButton> jButtonList = new ArrayList<>();

    public TelaAssentosForm(){
        inicializar();
    }

    private void inicializar(){
        this.setTitle("Assentos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);

        configuraArrayDeBotoes();
        event();
    }

    protected abstract void selecionaAssento(ActionEvent ev);

    private void event(){
        jbAssento01.addActionListener(this::selecionaAssento);
        jbAssento02.addActionListener(this::selecionaAssento);
        jbAssento03.addActionListener(this::selecionaAssento);
        jbAssento04.addActionListener(this::selecionaAssento);
        jbAssento05.addActionListener(this::selecionaAssento);
        jbAssento06.addActionListener(this::selecionaAssento);
        jbAssento07.addActionListener(this::selecionaAssento);
        jbAssento08.addActionListener(this::selecionaAssento);
    }

    public void configuraArrayDeBotoes(){
        jButtonList.add(jbAssento01);
        jButtonList.add(jbAssento02);
        jButtonList.add(jbAssento03);
        jButtonList.add(jbAssento04);
        jButtonList.add(jbAssento05);
        jButtonList.add(jbAssento06);
        jButtonList.add(jbAssento07);
        jButtonList.add(jbAssento08);
    }

    public JPanel getForm(){
        if(jpAssento == null){
            jpAssento = new JPanel(new GridLayout(4, 2, 15, 15));
            jbAssento01 = new JButton("01");
            jbAssento02 = new JButton("02");
            jbAssento03 = new JButton("03");
            jbAssento04 = new JButton("04");
            jbAssento05 = new JButton("05");
            jbAssento06 = new JButton("06");
            jbAssento07 = new JButton("07");
            jbAssento08 = new JButton("08");
        }
        return jpAssento;
    }

    public List<JButton> getjButtonList() {
        return jButtonList;
    }

    public void setjButtonList(List<JButton> jButtonList) {
        this.jButtonList = jButtonList;
    }
}
