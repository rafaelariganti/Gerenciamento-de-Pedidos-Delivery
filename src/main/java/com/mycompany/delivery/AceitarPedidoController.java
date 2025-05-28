package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class AceitarPedidoController {

    @FXML
    private ListView<String> listaPedidos;

    @FXML
    private Button btnAceitar;

    @FXML
    private void initialize() {
        // Simula alguns pedidos pendentes
        listaPedidos.getItems().addAll(
            "Pedido #101 - Hambúrguer",
            "Pedido #102 - Pizza",
            "Pedido #103 - Sushi"
        );
    }

    @FXML
    private void aceitarPedido() {
        String pedidoSelecionado = listaPedidos.getSelectionModel().getSelectedItem();
        if (pedidoSelecionado != null) {
            listaPedidos.getItems().remove(pedidoSelecionado);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pedido Aceito");
            alert.setHeaderText(null);
            alert.setContentText("Você aceitou: " + pedidoSelecionado);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nenhum pedido selecionado");
            alert.setHeaderText(null);
            alert.setContentText("Selecione um pedido para aceitar.");
            alert.showAndWait();
        }
    }
}
