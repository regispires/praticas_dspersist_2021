package br.ufc.quixada.entity;

import lombok.*;

import javax.persistence.*;

@NamedQueries({
		@NamedQuery(name = "clientePorCpf", query = "select c from Cliente c where c.cpf = :cpf")
})

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull @Getter @Setter private int id;

	@NonNull @Getter @Setter private String cpf;
	@Getter @Setter private String nome;
	@Getter @Setter private String fone;
	@Getter @Setter private double renda;
}
