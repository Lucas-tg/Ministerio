package br.edu.unifaj.poo.ministerio.Ministerio.Service;

import br.edu.unifaj.poo.ministerio.Ministerio.Dao.MinisterioDAO;
import br.edu.unifaj.poo.ministerio.Ministerio.Entity.Ministerio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinisterioService {

	@Autowired
	MinisterioDAO ministerioDAO;

	public Ministerio incluir(Ministerio m) throws Exception {
		return ministerioDAO.incluir(m);
	}

	public Ministerio alterar(Ministerio m) {
		return null;
	}

	public Ministerio excluir(Ministerio m) {
		return null;
	}

	public List<Ministerio> listar() throws Exception {
		return ministerioDAO.listar();
	}

}
