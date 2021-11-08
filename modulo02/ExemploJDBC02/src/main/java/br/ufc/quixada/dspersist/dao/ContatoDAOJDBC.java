package br.ufc.quixada.dspersist.dao;

import br.ufc.quixada.dspersist.model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAOJDBC implements ContatoDAO {
    @Override
    public List<Contato> findAll() {
        List<Contato> contatos = new ArrayList<Contato>();
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            System.out.println("Conexão OK!!!");

            String sql = "select * from contatos";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setEmail(rs.getString("email"));
                contatos.add(contato);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DAOException(e);
                }
            }
        }
       return contatos;
    }
}
