package br.edu.unifaj.poo.ministerio.Ministerio.Entity;

import lombok.Data;

@Data
public class Secretaria {

	private Long id;

	private String nome;

	private int totalCargosConfianca;

	private int totalFuncionarios;

	private Double orcamento;

}
