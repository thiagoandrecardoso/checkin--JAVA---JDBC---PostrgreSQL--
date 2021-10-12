package view;

import model.Bilhete;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class TelaInfoBilheteForm extends JFrame {
    protected JPanel jPanelInfoBilhete;
    protected JLabel jLabelOrigem;
    protected JLabel jLabelDestino;
    protected JLabel jLabelHoraPrevistaEmbarque;
    protected JLabel jLabelHoraPrevistaPartida;
    protected JLabel jLabelHoraRelogioParede;
    protected JTextField txtNome;
    protected JTextField txtCpf;
    protected JButton btnAtualizarDadosPessoais;
    protected JButton btnProximo;

    private final Bilhete bilhete;

    public TelaInfoBilheteForm(Bilhete bilhete) {
        this.bilhete = bilhete;
        inicializar();
    }

    private void inicializar() {
        this.setTitle("Informações do bilhete");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getBilheteForm(), BorderLayout.CENTER);
        this.setResizable(false);
    }

    public JPanel getBilheteForm() {
        if (jPanelInfoBilhete == null){
            jPanelInfoBilhete = new JPanel(new GridLayout(5, 1));
            jLabelOrigem = new JLabel("Origem: " + bilhete.getLinha().getOrigem());
            jLabelDestino = new JLabel("Destino: " + bilhete.getLinha().getDestino());
            jLabelHoraPrevistaEmbarque = new JLabel("Hora prevista do embarque: " + bilhete.getLinha().getHora_embarque());
            jLabelHoraPrevistaPartida = new JLabel("Hora prevista da partida: " + bilhete.getLinha().getHora_partida());
            jLabelHoraRelogioParede = new JLabel("Hora atual: " + LocalTime.now());

            jPanelInfoBilhete.add(jLabelOrigem);
            jPanelInfoBilhete.add(jLabelDestino);
            jPanelInfoBilhete.add(jLabelHoraPrevistaEmbarque);
            jPanelInfoBilhete.add(jLabelHoraPrevistaPartida);
            jPanelInfoBilhete.add(jLabelHoraRelogioParede);
        }
        return jPanelInfoBilhete;
    }
}
