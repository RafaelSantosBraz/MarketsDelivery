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
        //construtor da classe assim sempre vc vai ter uma conexao
        this.con = ConexaoPGSQL.getConnection();
    }

    public ArrayList<Produto> buscarProduto(String textoBuscar) throws SQLException {
        ArrayList<Produto> lista = new ArrayList<Produto>();
        PreparedStatement stm = this.con.prepareStatement("SELECT * FROM Produto WHERE nome LIKE %" + textoBuscar + "%");
        ResultSet result = stm.executeQuery();
        while (result.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(result.getInt("id"));
            produto.setNome(result.getString("nome"));
            produto.setMarca(result.getString("marca"));
            produto.setPreco(result.getDouble("preco"));
            lista.add(produto);
        }
        result.close();
        stm.close();
        return lista;
    }
}
