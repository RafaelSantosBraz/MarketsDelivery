/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Henrique Ricordi
 */
public class Carrinho {

    private int idCarrinho;
    private double valorTotal;
    private boolean status;
    private Consumidor consumidor;
    private ArrayList<ItemCarrinho> listaProdutos;

    public void adicionarCarrinho(Produto produto) {
        ItemCarrinho itemCarrinho = new ItemCarrinho();

        itemCarrinho.setProduto(produto);
        itemCarrinho.setQuantidade(1);
        itemCarrinho.setValorFinal(produto.getPreco());

        listaProdutos.add(itemCarrinho);
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public double getValorTotal() {
        valorTotal = 0;
        for (int i = 0; i < listaProdutos.size(); i++) {
            valorTotal += listaProdutos.get(i).getValorFinal();
        }
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public ArrayList<ItemCarrinho> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<ItemCarrinho> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
