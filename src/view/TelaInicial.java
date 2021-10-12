package view;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TelaInicial extends TelaInicialForm {

    @Override
    protected void abrirTelaRealizarCHekin(ActionEvent ev) {

    }

    @Override
    protected void adicionarEscutaCheckBox() {
        cbCheckin.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbCheckin.isSelected()) txtCheckin.setEditable(true);
            }
        });
    }
}
