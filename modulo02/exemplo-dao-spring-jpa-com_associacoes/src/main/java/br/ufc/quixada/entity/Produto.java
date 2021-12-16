package br.ufc.quixada.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;

	@NonNull @Getter @Setter private String nome;
	@Getter @Setter float valorAtual;
}
