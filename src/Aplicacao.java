import control.TelaInicial;

import javax.swing.*;

public class Aplicacao {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial inicial = new TelaInicial();
            inicial.setVisible(true);
        });
    }
}
