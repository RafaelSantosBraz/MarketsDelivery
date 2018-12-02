/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrinho;
import model.Produto;

/**
 *
 * @author Henrique Ricordi
 */

public class Controle {
    
    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static Controle instance;

    public static Controle getInstance() {
        if (instance == null) {
            instance = new Controle();
        }
        return instance;
    }
    //</editor-fold> 
    
    ArrayList<Produto> listaResultado;
    Carrinho carrinho = new Carrinho();
    public String caminho;
    
    public ArrayList<Produto> buscarProduto(String textoBusca){
        ProdutoDAO produto;
        try {
            produto = new ProdutoDAO();
            return produto.buscarProduto(textoBusca);
        } catch (SQLException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    public ArrayList<Produto> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(ArrayList<Produto> listaResultado) {
        this.listaResultado = listaResultado;
    }       

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }            
}
