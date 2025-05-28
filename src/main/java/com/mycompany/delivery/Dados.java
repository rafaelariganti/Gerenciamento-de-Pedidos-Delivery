package com.mycompany.delivery;

import java.util.ArrayList;

public class Dados {
    private Fila filaEspera = new Fila(10); // IDs dos pedidos em espera
    private ArrayList<Pedido> todosPedidos = new ArrayList<>(); // todos os pedidos criados
    private ArrayList<Pedido> pedidosEmPreparo = new ArrayList<>();
    private ArrayList<Pedido> pedidosFinalizados = new ArrayList<>();

    // 1. Adicionar novo pedido
    public void adicionarPedido(int id, String nomeCliente, String itens) {
        if (!filaEspera.cheia()) {
            String[] itensSeparados = itens.split(","); // Ex: "Hamburguer, Coca" → ["Hamburguer", "Coca"]
            Pedido p = new Pedido(id,nomeCliente,itensSeparados);
            todosPedidos.add(p);
            filaEspera.enfileirar(id);
            System.out.println("Pedido adicionado à fila de espera.");
        } else {
            System.out.println("Fila cheia, não foi possível adicionar o pedido.");
        }
    }

    // 2. Aceitar pedido
    public void aceitarPedido() {
        String idStr = filaEspera.desenfileirar();
        try {
            int id = Integer.parseInt(idStr);
            Pedido p = buscarPedidoPorId(id);
            if (p != null) {
                p.setStatus("Em preparo");
                pedidosEmPreparo.add(p);
                System.out.println("Pedido " + id + " movido para preparo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao aceitar pedido: " + idStr);
        }
    }

    // 3. Registrar etapa
    public void registrarEtapa(int id, String etapa) {
        Pedido p = buscarPedidoPorId(id);
        if (p != null && p.getStatus().equals("Em preparo")) {
            p.registrarEtapa(etapa);
            System.out.println("Etapa registrada: " + etapa);
        } else {
            System.out.println("Pedido não encontrado ou não está em preparo.");
        }
    }

    // 4. Desfazer última etapa
    public void desfazerUltimaEtapa(int id) {
        Pedido p = buscarPedidoPorId(id);
        if (p != null) {
            String etapaDesfeita = p.desfazerUltimaEtapa();
            System.out.println("Etapa desfeita: " + etapaDesfeita);
        }
    }

    // 5. Finalizar preparo
    public void finalizarPedido(int id) {
        Pedido p = buscarPedidoPorId(id);
        if (p != null && p.getStatus().equals("Em preparo")) {
            p.setStatus("Finalizado");

            // Remove da lista de preparo
            pedidosEmPreparo.remove(p);
            pedidosFinalizados.add(p);

            // Exibe histórico
            System.out.println("Pedido finalizado. Etapas realizadas:");
            for (String etapa : p.getHistorico()) {
                if (etapa != null) {
                    System.out.println("- " + etapa);
                }
            }
        }
    }

    // 6. Visualizar pedidos ativos
    public void listarPedidosEmPreparo() {
        System.out.println("Pedidos em preparo:");
        for (Pedido p : pedidosEmPreparo) {
            System.out.println("ID: " + p.getID() + " - Cliente: " + p.getNomeCliente());
        }
    }

    // 7. Consultar histórico de preparo
    public void consultarHistorico(int id) {
        Pedido p = buscarPedidoPorId(id);
        if (p != null) {
            System.out.println("Histórico do pedido " + id + ":");
            for (String etapa : p.getHistorico()) {
                if (etapa != null) {
                    System.out.println("- " + etapa);
                }
            }
        }
    }

    // 8. Reencaminhar pedido finalizado
    public void reencaminharPedido(int id) {
        Pedido p = buscarPedidoPorId(id);
        if (p != null && p.getStatus().equals("Finalizado")) {
            p.setStatus("Em espera");
            filaEspera.enfileirar(p.getID());
            pedidosFinalizados.remove(p);
            System.out.println("Pedido " + id + " reenviado para fila de espera.");
        }
    }

    // Busca auxiliar
    private Pedido buscarPedidoPorId(int id) {
        for (Pedido p : todosPedidos) {
            if (p.getID() == id) return p;
        }
        return null;
    }

    public Fila getFilaEspera() {
         return filaEspera;
    }

    public Pedido getPedidoPorId(int id) {
         return buscarPedidoPorId(id);
    }

    public ArrayList<Pedido> getPedidosEmPreparo() {
         return pedidosEmPreparo;
    }




}
