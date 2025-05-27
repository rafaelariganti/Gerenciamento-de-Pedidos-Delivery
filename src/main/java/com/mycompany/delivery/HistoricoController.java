package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.List;

public class HistoricoController {

    @FXML
    private TextArea areaHistorico;

    @FXML
    public void initialize() {
        atualizarHistorico();
    }

    @FXML
    private void atualizarHistorico() {
        List<Pedido> historico = PilhaHistorico.getInstancia().getTodos();
        StringBuilder sb = new StringBuilder();

        if (historico.isEmpty()) {
            sb.append("Nenhum pedido finalizado ainda.");
        } else {
            for (int i = historico.size() - 1; i >= 0; i--) {
                Pedido p = historico.get(i);
                sb.append((historico.size() - i)).append(") Cliente: ").append(p.getNomeCliente()).append("\n");
            }
        }

        areaHistorico.setText(sb.toString());
    }
}
