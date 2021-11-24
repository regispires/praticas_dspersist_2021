package dao;

import entity.Contato;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoJDBCDAO implements ContatoDAO {
    // a conexão com o banco de dados
    private Connection connection;

    public ContatoJDBCDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Contato contato) {
        String sql = "insert into contatos " +
                "(nome,email,endereco)" +
                " values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto entity.Contato
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getListaPaginada(int pagina, int tamanhoPagina) {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos limit ? offset ?");
            stmt.setInt(1, tamanhoPagina);
            stmt.setInt(2, pagina * tamanhoPagina - tamanhoPagina);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto entity.Contato
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
