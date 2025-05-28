package com.mycompany.delivery;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class PainelCozinhaController {

    @FXML private Label lblProximo;
    @FXML private ListView<String> listaEmPreparo;

    private Dados dados = App.getDados();

    @FXML
    public void initialize() {
        atualizarPainel();
    }

    public void atualizarPainel() {
        // Não temos um método direto para ver o próximo, então pegamos manualmente da fila
        String proximoId = dados.getFilaEspera().espiar(); // método espiar() precisa ser implementado na Fila
        if (proximoId != null) {
            try {
                int id = Integer.parseInt(proximoId);
                Pedido p = dados.getPedidoPorId(id); // precisa criar este método público no Dados
                if (p != null) {
                    lblProximo.setText("Próximo: " + p.getNomeCliente() + " (ID: " + id + ")");
                }
            } catch (NumberFormatException e) {
                lblProximo.setText("Erro ao ler próximo pedido.");
            }
        } else {
            lblProximo.setText("Nenhum pedido na fila.");
        }

        listaEmPreparo.getItems().clear();
        for (Pedido p : dados.getPedidosEmPreparo()) {
            listaEmPreparo.getItems().add("ID: " + p.getID() + " - " + p.getNomeCliente());
        }
    }

    public void aceitarPedido() {
        dados.aceitarPedido();
        atualizarPainel();
    }

    public void finalizarPedido() {
        Pedido selecionado = getPedidoSelecionado();
        if (selecionado != null) {
            dados.finalizarPedido(selecionado.getID());
            atualizarPainel();
        }
    }

    public void registrarEtapa() {
        Pedido selecionado = getPedidoSelecionado();
        if (selecionado != null) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Registrar Etapa");
            dialog.setContentText("Etapa:");
            dialog.showAndWait().ifPresent(etapa -> {
                dados.registrarEtapa(selecionado.getID(), etapa);
                atualizarPainel();
            });
        }
    }

    public void desfazerEtapa() {
        Pedido selecionado = getPedidoSelecionado();
        if (selecionado != null) {
            dados.desfazerUltimaEtapa(selecionado.getID());
            atualizarPainel();
        }
    }

    private Pedido getPedidoSelecionado() {
        String linha = listaEmPreparo.getSelectionModel().getSelectedItem();
        if (linha != null) {
            try {
                int id = Integer.parseInt(linha.split(" ")[1]); // "ID: 5 - Nome"
                return dados.getPedidoPorId(id); // este método precisa existir
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}
