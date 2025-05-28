package com.mycompany.delivery;

public class Pilha {

    private int topo;
    private int tamanho;
    private Object pilhaElem[];

    public Pilha(int tam) {
        topo = -1;
        tamanho = tam;
        pilhaElem = new Object[tam];
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == tamanho - 1;
    }

    public void empilhar(Object elem) {
        if (cheia()) {
            System.out.println("A pilha está cheia!");
        } else {
            topo++;
            pilhaElem[topo] = elem;
        }
    }

    public Object desempilhar() {
        Object valorDesempilhado;
        if (vazia()) {
            valorDesempilhado = "Pilha Vazia!";
        } else {
            valorDesempilhado = pilhaElem[topo];
            topo--;
        }
        return valorDesempilhado;
    }

    public void ExibePilha() {
        if (vazia()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println("Elemento " + pilhaElem[i] + " - posição " + i);
            }
        }
    }
    public Object getElemento(int index) {
        if (index >= 0 && index <= topo) {
            return pilhaElem[index];
        }
        return null;
    }
}
