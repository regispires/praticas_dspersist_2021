package br.ufc.quixada.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
		@NamedQuery(name = "clientePorCpf", query = "select c from Cliente c where c.cpf = :cpf")
})

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "compras")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;

	@NonNull @Getter @Setter private String cpf;
	@Getter @Setter private String nome;
	@Getter @Setter private String fone;
	@Getter @Setter private double renda;

	@OneToMany(mappedBy = "cliente")
	@Getter @Setter private List<Compra> compras;
}
