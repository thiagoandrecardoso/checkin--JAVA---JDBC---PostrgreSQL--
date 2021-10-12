package view;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TelaInicial extends TelaInicialForm {

    @Override
    protected void btnActionProximo(ActionEvent ev) {

    }

    @Override
    protected void adicionarEscutaCheckBox() {
        cbCheckin.addItemListener(e -> {
            if (cbCheckin.isSelected()) {
                txtCheckin.setEditable(true);
                txtCheckin.requestFocusInWindow();
            }
        });
    }
}
