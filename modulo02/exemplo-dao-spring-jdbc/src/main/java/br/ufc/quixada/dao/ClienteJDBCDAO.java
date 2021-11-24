package br.ufc.quixada.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ClienteJDBCDAO implements ClienteDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public ClienteJDBCDAO() { }
	
	public void save(Cliente entity) {
		String insert_sql = "insert into clientes (cpf, nome, fone, renda) values (:cpf, :nome, :fone, :renda)";
		String update_sql = "update clientes set cpf = :cpf, nome = :nome, fone = :fone, renda = :renda where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("cpf",  entity.getCpf())
				.addValue("nome", entity.getNome())
				.addValue("fone", entity.getFone())
				.addValue("renda", entity.getRenda());

		if (entity.getId() == 0) {
			jdbcTemplate.update(insert_sql, params);
		} else {
			params.addValue("id", entity.getId());
			jdbcTemplate.update(update_sql, params);
		}
	}

	public void delete(int id) {
		String sql = "delete from clientes where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("id",  id);
		jdbcTemplate.update(sql, params);
	}

	private Cliente map(ResultSet rs) throws SQLException {
		Cliente cl = new Cliente();
		cl.setId(rs.getInt("id"));
		cl.setCpf(rs.getString("cpf"));
		cl.setNome(rs.getString("nome"));
		cl.setFone(rs.getString("fone"));
		cl.setRenda(rs.getBigDecimal("renda").doubleValue());
		return cl;
	}

	public Cliente find(int id) {
		String sql = "select id, cpf, nome, fone, renda from clientes where id = :id_";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id_", id);
		return jdbcTemplate.queryForObject(sql, namedParameters, (rs, rowNum) -> map(rs));
	}

	public List<Cliente> find() {
		String sql = "select id, cpf, nome, fone, renda from clientes";
		return jdbcTemplate.query(sql, (rs, rowNum) -> map(rs));
	}

	public Cliente findByCpf(String cpf) {
		String sql = "select id, cpf, nome, fone, renda from clientes where cpf = :cpf_";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("cpf_", cpf);
		List<Cliente> result = jdbcTemplate.query(sql, namedParameters, (rs, rowNum) -> map(rs));
		return result.isEmpty() ? null : result.get(0);
	}

	public List<Cliente> findByNome(String str) {
		String sql = "select id, cpf, nome, fone, renda from clientes where upper(nome) like :nome_";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("nome_", "%" + str.toUpperCase() + "%");
		return jdbcTemplate.query(sql, namedParameters, (rs, rowNum) -> map(rs));
	}
	
}
