package view;

import model.Bilhete;
import model.Passageiro;

import javax.swing.*;
import java.awt.*;

public class TelaEditaPassageiroForm extends JFrame {
    public Bilhete bilhete;
    public Passageiro passageiro;

    public JPanel jpPassageiro;
    public JTextField txtNome;
    public JTextField txtCpf;
    public JTextField txtTelefone;
    public JTextField txtEmail;

    public JButton btnSalvar;

    public TelaEditaPassageiroForm(Bilhete bilhete){
        this.bilhete = bilhete;
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Passageiro");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getEditForm(), BorderLayout.CENTER);
        btnSalvar = new JButton("Salvar");
        this.getContentPane().add(btnSalvar, BorderLayout.PAGE_END);
        this.setResizable(false);
        event();
    }

    private void event() {
    }

    public JPanel getEditForm(){
        if (jpPassageiro == null){
            jpPassageiro = new JPanel(new GridLayout(4, 2));

            jpPassageiro.add(new JLabel("Nome: "));
            txtNome = new JTextField(bilhete.getPassageiro().getNome());
            jpPassageiro.add(txtNome);

            jpPassageiro.add(new JLabel("CPF: "));
            txtCpf = new JTextField(bilhete.getPassageiro().getCpf());
            jpPassageiro.add(txtCpf);

            jpPassageiro.add(new JLabel("Telefone: "));
            txtTelefone = new JTextField(bilhete.getPassageiro().getTelefone_contato());
            jpPassageiro.add(txtTelefone);

            jpPassageiro.add(new JLabel("email: "));
            txtEmail = new JTextField(bilhete.getPassageiro().getEmail());
            jpPassageiro.add(txtEmail);

            jpPassageiro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        }

        return jpPassageiro;
    }

}
