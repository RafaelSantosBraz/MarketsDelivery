/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DAOControle;
import dao.ProdutoDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    private ArrayList<Produto> listaResultado;
    private Carrinho carrinho;
    
    public Controle(){
        carrinho = new Carrinho();
    }
    
    public boolean alterarProdutos(String caminho) {
        try {
            FileReader csvFile = new FileReader(caminho);
            BufferedReader csv = new BufferedReader(csvFile);
            ArrayList<Produto> produtos = new ArrayList<>();
            //ignora a primeira linha
            String linha = csv.readLine();
            while ((linha = csv.readLine()) != null) {
                String dadosProduto[] = linha.split(",");
                Produto produto = new Produto();
                produto.setIdProduto(Integer.parseInt(dadosProduto[0]));
                produto.setNome(dadosProduto[1]);
                produto.setMarca(dadosProduto[2]);
                produto.setPreco(Double.parseDouble(dadosProduto[3]));
                produtos.add(produto);
            }
            DAOControle dao = new DAOControle();
            dao.atualizarProdutos(produtos);
            csvFile.close();
            JOptionPane.showMessageDialog(null, "Produtos adicionados!", "Sucesso", 1);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar o arquivo selecionado!", "Erro de Arquivo", 0);
            return false;
        }
    }
    
    public ArrayList<Produto> buscarProduto(String textoBusca) {
        DAOControle c = new DAOControle();
        return c.buscarProduto(textoBusca);
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
