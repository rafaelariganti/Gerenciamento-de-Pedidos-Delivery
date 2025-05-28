package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CancelarPedidoController {

    @FXML
    private TextArea areaCancelamento;

    @FXML
    public void desfazerUltimaEtapa() {
        Pedido pedidoAtual = FilaPedidos.getInstancia().getPedidoEmAtendimento();

        if (pedidoAtual == null) {
            areaCancelamento.setText("❌ Nenhum pedido em atendimento.");
            return;
        }

        String etapaDesfeita = pedidoAtual.desfazerUltimaEtapa();

        if (etapaDesfeita != null) {
            areaCancelamento.setText("✅ Última etapa cancelada:\n" + etapaDesfeita);
        } else {
            areaCancelamento.setText("⚠️ Nenhuma etapa para desfazer.");
        }
    }
}
