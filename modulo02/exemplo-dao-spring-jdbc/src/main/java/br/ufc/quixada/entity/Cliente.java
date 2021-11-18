package br.ufc.quixada.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Cliente {
	@NonNull @Getter @Setter private int id;
	@NonNull @Getter @Setter private String cpf;
	@Getter @Setter private String nome;
	@Getter @Setter private String fone;
	@Getter @Setter private double renda;
}
