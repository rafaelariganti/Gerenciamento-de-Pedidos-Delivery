/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Rafaela
 */
public class DeliveryController {

    private void abrirNovaJanela(String caminhoFXML, String tituloJanela) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(tituloJanela);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void adicionarPedido(ActionEvent event) {
        abrirNovaJanela("NovoPedido.fxml", "Adicionar Novo Pedido");
    }

    @FXML
    private void aceitarPedido(ActionEvent event) {
        abrirNovaJanela("AceitarPedido.fxml", "Fila de Espera");
    }

    @FXML
    private void visualizarPedidos(ActionEvent event) {
        abrirNovaJanela("PedidoAtivo.fxml", "Pedidos Ativos");
    }

    @FXML
    private void registrarEtapa(ActionEvent event) {
        abrirNovaJanela("RegistrarEtapa.fxml", "Registrar Etapa do Preparo");
    }

    @FXML
    private void desfazerEtapa(ActionEvent event) {
        abrirNovaJanela("DesfazerEtapa.fxml", "Desfazer Última Etapa");
    }

    @FXML
    private void finalizarPedido(ActionEvent event) {
        abrirNovaJanela("FinalizarPedido.fxml", "Finalizar Preparo");
    }

    @FXML
    private void consultarHistorico(ActionEvent event) {
        abrirNovaJanela("Historico.fxml", "Histórico de Preparo");
    }

    @FXML
    private void reencaminharPedido(ActionEvent event) {
        abrirNovaJanela("ReencaminharPedido.fxml", "Reencaminhar Pedido Finalizado");
    }
}
