package com.mycompany.delivery;

public class Pedido {
    private int ID;
    private String nomeCliente;
    private String[] itens;
    private String status;
    private Pilha etapasPreparo = new Pilha(10); // Pilha para as etapas

    public Pedido(int ID, String nomeCliente, String[] itens) {
        this.ID = ID;
        this.nomeCliente = nomeCliente;
        this.itens = itens;
        this.status = "Aguardando"; // Status inicial
    }

    // Getters e Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String[] getItens() {
        return itens;
    }

    public void setItens(String[] itens) {
        this.itens = itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Adiciona uma etapa à pilha
    public void registrarEtapa(String etapa) {
        etapasPreparo.empilhar(etapa);
    }

    // Desfaz a última etapa (desempilha)
    public String desfazerUltimaEtapa() {
        Object desempilhado = etapasPreparo.desempilhar();
        return desempilhado != null ? desempilhado.toString() : "Nada para desfazer";
    }

    // Retorna as etapas atuais em ordem (do fundo para o topo da pilha)
    public String[] getHistorico() {
        int tamanho = 0;
        for (int i = 0; i < 10; i++) {
            if (etapasPreparo.getElemento(i) != null) {
                tamanho++;
            }
        }

        String[] historico = new String[tamanho];
        for (int i = 0; i < tamanho; i++) {
            historico[i] = etapasPreparo.getElemento(i).toString();
        }

        return historico;
    }

    public Pilha getEtapasPreparo() {
        return etapasPreparo;
    }

    public void setEtapasPreparo(Pilha etapasPreparo) {
        this.etapasPreparo = etapasPreparo;
    }

    // Exibir itens como string
    public String getItensComoString() {
        StringBuilder sb = new StringBuilder();
        for (String item : itens) {
            sb.append(item).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }
}
