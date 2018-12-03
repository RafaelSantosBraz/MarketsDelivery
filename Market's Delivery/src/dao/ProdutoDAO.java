/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Henrique Ricordi
 */
public class ProdutoDAO {

    private Connection con;

    public ProdutoDAO() throws SQLException {
        this.con = ConexaoPGSQL.getConnection();
    }

    public ArrayList<Produto> buscarProduto(String textoBuscar) throws SQLException {
        ArrayList<Produto> lista = new ArrayList<Produto>();
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM Produto WHERE nome LIKE '%" + textoBuscar + "%'");
        ResultSet result = stm.executeQuery();
        while (result.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(result.getInt("idProduto"));
            produto.setNome(result.getString("nome"));
            produto.setMarca(result.getString("marca"));
            produto.setPreco(result.getDouble("preco"));
            lista.add(produto);
        }
        result.close();
        stm.close();
        return lista;
    }

    public Boolean atualizarProduto(Produto produto) throws SQLException {
        PreparedStatement stm = this.con.prepareStatement("update Produto set nome = '" + produto.getNome() + "', marca = '" + produto.getMarca() + "', preco = " + produto.getPreco() + " where nome = '" + produto.getNome() + "';");
       stm.executeUpdate();        
        //result.close();
        stm.close();
        return true;
    }
    
    public Boolean inserirProduto(Produto produto) throws SQLException {
        PreparedStatement stm = this.con.prepareStatement("INSERT INTO Produto VALUES (DEFAULT, '" + produto.getNome() + "', '" + produto.getMarca() + "', " + produto.getPreco() + ")");
        stm.execute();                
        stm.close();
        return true;
    }
}
