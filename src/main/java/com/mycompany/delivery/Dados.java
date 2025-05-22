/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delivery;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Ronaldo
 */
public class Dados {
    //composição da classe dados 
    Fila f = new Fila(10);
    ArrayList<String[]> pedidos = new ArrayList<>();

    //precisamos formatar o retorno dos dados
    public String[] getList(){
        String[] formatList ={};
        return formatList;
    }

    public void addFila(int e, String itens){
        //dividindo itens
        String[] itensPedido = itens.split(" ");
        //enfilera se a fila não estiver cheia
        if(!f.cheia()){
            f.enfileirar(e);
            String[] vetor ={Integer.toString(e)};
            pedidos.add(vetor);pedidos.add(itensPedido);
        }
    }
    public String removeFila(boolean verdade){
        //se verdade retorna o valor se falso apenas tira
        if(verdade){return f.desenfileirar();} else{f.desenfileirar();return"";}
    }



}