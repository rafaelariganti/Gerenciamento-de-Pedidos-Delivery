package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.List;

public class PedidoAtivoController {

    @FXML
    private TextArea areaPedidos;

    @FXML
    public void initialize() {
        atualizarLista();
    }

    @FXML
    private void atualizarLista() {
        List<Pedido> pedidos = FilaPedidos.getInstancia().getTodos();
        StringBuilder sb = new StringBuilder();

        if (pedidos.isEmpty()) {
            sb.append("Nenhum pedido ativo no momento.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido p = pedidos.get(i);
                sb.append((i + 1)).append(") Cliente: ").append(p.getNomeCliente()).append("\n");
            }
        }

        areaPedidos.setText(sb.toString());
    }
}
