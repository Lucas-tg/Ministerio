package br.edu.unifaj.poo.ministerio.Ministerio.Dao;

import br.edu.unifaj.poo.ministerio.Ministerio.Entity.Ministerio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MinisterioDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;


	public Ministerio incluir(Ministerio m) throws Exception{
		//validarMinisterio(m, true);
		String sqlInsert = "INSERT INTO ministerio(id_ministerio, nome_ministerio, totalCargosConfianca_ministerio,\n" +
				"                                totalFuncionarios_ministerio, orcamento_ministerio) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection con = jdbcTemplate.getDataSource().getConnection();
			 PreparedStatement ps = con.prepareStatement(
					 sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			ps.setLong(1, m.getId());
			ps.setString(2, m.getNome());
			ps.setInt(3, m.getTotalCargosConfianca());
			ps.setInt(4, m.getTotalFuncionarios());
			ps.setDouble(5, m.getOrcamento());
			int result = ps.executeUpdate();
			//ResultSet generatedKeys = ps.getGeneratedKeys();
			//if (generatedKeys.next()) {
			if(result == 1){
				ResultSet tableKeys = ps.getGeneratedKeys(); //ID Gerado.
				tableKeys.next();
				m.setId(tableKeys.getLong(1));
				System.out.println("Ministerio inserida com sucesso:" + m.getNome());
				return m;
			}
			throw new Exception("Erro ao inserir no banco.");
		}

	}


	private void validarMinisterio(Ministerio m, boolean incluir) throws Exception {
		if (m.getNome() == null || m.getNome().trim().isEmpty()) {
			throw new Exception("Nome da pessoa vazio");
		}
		if (incluir) {
			String query = "select * from ministerio where nome_ministerio = ?";
			try (Connection con = jdbcTemplate.getDataSource().getConnection();
				 PreparedStatement ps = con.prepareStatement(query);) {
				ps.setString(1, m.getNome());
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						throw new Exception("Nome já cadastrado");
					}
				}
			}
		}
	}

	public Ministerio alterar(Ministerio m) {
		return null;
	}

	public Ministerio excluir(Ministerio m) {
		return null;
	}


//	public List<Ministerio> listar(Ministerio ministerio) throws Exception {
//		try {
//			List<Ministerio> ministerios = new ArrayList<>();
//			Connection con = jdbcTemplate.getDataSource().getConnection();
//			String query = "SELECT id_ministerio, nome_ministerio, totalCargosConfianca_ministerio, totalFuncionarios_ministerio, orcamento_ministerio, nota FROM ministerio WHERE id_ministerio=?";
//			PreparedStatement statement = con.prepareStatement(query);
//			statement.setLong(1, ministerio.getId()); // int ou long?
//			ResultSet result = statement.executeQuery();
//			while (result.next()) {
//				Long id_ministerio = result.getLong("id_ministerio");
//				String nome_ministerio = result.getString("nome_ministerio");
//				int totalCargosConfianca_ministerio = result.getInt("totalCargosConfianca_ministerio");
//				int totalFuncionarios_ministerio = result.getInt("totalFuncionarios_ministerio");
//				Double orcamento_ministerio = result.getDouble("orcamento_ministerio");
//				ministerios.add(new Ministerio(id_ministerio, nome_ministerio, totalCargosConfianca_ministerio, totalFuncionarios_ministerio, orcamento_ministerio));
//
//			}
//			con.close();
//			statement.close();
//			return ministerios;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("Falha ao recuperar avaliacoes da receita: " + ministerio.getNome());
//		}
//	}

	public List<Ministerio> listar() throws Exception {
		List<Ministerio> ministerios = new ArrayList<>();
		String query = "SELECT id_ministerio, nome_ministerio, totalCargosConfianca_ministerio, totalFuncionarios_ministerio, orcamento_ministerio, FROM ministerio";
		try (Connection con = jdbcTemplate.getDataSource().getConnection();
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				Ministerio m = new Ministerio();

				m.setId(rs.getLong("id_ministerio"));
				m.setNome(rs.getString("nome_ministerio"));
				m.setTotalCargosConfianca(rs.getInt("totalCargosConfianca_ministerio"));
				m.setTotalFuncionarios(rs.getInt("totalFuncionarios_ministerio"));
				m.setOrcamento(rs.getDouble("orcamento_ministerio"));

				ministerios.add(m);

			}
		} catch (Exception e) {
			System.err.println("Erro ao obter os dados:" + e);
			throw e;
		}
		return ministerios;
	}
}

