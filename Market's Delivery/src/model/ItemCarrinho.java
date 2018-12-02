/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Henrique Ricordi
 */
public class ItemCarrinho {
    private int idItemCarrinho;
    private int quantidade;
    private double valorFinal;
    private Produto produto;

    public int getIdItemCarrinho() {
        return idItemCarrinho;
    }

    public void setIdItemCarrinho(int idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }          
}
