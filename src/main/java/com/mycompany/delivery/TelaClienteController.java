package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaClienteController {

    @FXML private TextField txtID;
    @FXML private TextField txtNome;
    @FXML private TextField txtItens;
    @FXML private Label lblStatus;

    private Dados dados = App.getDados();

    public void enviarPedido() {
        try {
            int id = Integer.parseInt(txtID.getText());
            String nome = txtNome.getText();
            String itens = txtItens.getText();

            dados.adicionarPedido(id, nome, itens);
            lblStatus.setText("Pedido enviado com sucesso!");

            txtID.clear();
            txtNome.clear();
            txtItens.clear();
        } catch (NumberFormatException e) {
            lblStatus.setText("ID inválido.");
        }
    }
}
