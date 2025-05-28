package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class NovoPedidoController {

    @FXML
    private TextField campoNomeCliente;

    @FXML
    private void adicionar() {
        String nome = campoNomeCliente.getText().trim();

        if (nome.isEmpty()) {
            mostrarAlerta("Erro", "O nome do cliente não pode estar vazio.");
            return;
        }

        Pedido novoPedido = new Pedido(nome);
        FilaPedidos.getInstancia().adicionar(novoPedido);

        mostrarAlerta("Sucesso", "Pedido adicionado com sucesso!");

        campoNomeCliente.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
