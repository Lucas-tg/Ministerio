package br.edu.unifaj.poo.ministerio.Ministerio.Controller;
import br.edu.unifaj.poo.ministerio.Ministerio.Entity.Ministerio;
import br.edu.unifaj.poo.ministerio.Ministerio.Retorno;
import br.edu.unifaj.poo.ministerio.Ministerio.Service.MinisterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ministerio")
public class MinisterioController {

	private final MinisterioService ministerioService;

	@Autowired
	public MinisterioController(MinisterioService ministerioService) {
		this.ministerioService = ministerioService;
	}

	@PostMapping("/incluir")
	public Retorno incluir(@RequestBody Ministerio m) {
		try {
			return new Retorno(ministerioService.incluir(m));
		} catch (Exception ex) {
			return new Retorno(ex.getMessage());
		}
	}

	public Ministerio alterar(Ministerio m) {
		return null;
	}

	public Ministerio excluir(Ministerio m) {
		return null;
	}

	@GetMapping("/listar")
	public List<Ministerio> listar() throws Exception {
		return ministerioService.listar();
	}

	public List<Ministerio> gerarRelatorio() {
		return null;
	}

}
