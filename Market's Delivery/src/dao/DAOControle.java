/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author a120121
 */
public class DAOControle {

    public ArrayList<Produto> buscarProduto(String textoBuscar) {
        try {
            ProdutoDAO p = new ProdutoDAO();
            return p.buscarProduto(textoBuscar);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar busca no Banco de Dados!", "Erro de SQL", 0);
            return new ArrayList<>();
        }
    }
}
