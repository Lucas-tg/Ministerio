package br.edu.unifaj.poo.ministerio.Ministerio.Entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Data
public class Ministerio {


	private Long id;

	private String nome;

	private int totalCargosConfianca;

	private int totalFuncionarios;

	private Double orcamento;

//	private Secretaria[] secretaria;
}
