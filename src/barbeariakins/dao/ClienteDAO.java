package barbeariakins.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import barbeariakins.conexao.ConexaoBanco;

public class ClienteDAO {

    public void cadastrarCliente(String nome) {
        String sql = "INSERT INTO cliente (nome, telefone, descricao, Agendamento_id_Agendamento) VALUES (?, '', '', 1)";
        
        
        try {
           Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.execute();

            conn.close();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e);
        }
      
    }

    public List<String> listarClientes() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM cliente";

        try {
            Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
               String nome = rs.getString("nome");

if (nome != null && !nome.isEmpty()) {
    lista.add(nome);
}
                
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e);
        }

        return lista;
    }

public void excluirCliente(String nome) {
    String sql = "DELETE FROM cliente WHERE nome = ?";

    try (Connection conn = ConexaoBanco.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.execute();

        System.out.println("Cliente excluído com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao excluir: " + e);
    }
}
}

