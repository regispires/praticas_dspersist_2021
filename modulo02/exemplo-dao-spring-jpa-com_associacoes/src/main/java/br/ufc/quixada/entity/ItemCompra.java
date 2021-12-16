package br.ufc.quixada.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "itens_compras")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ItemCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;

	@ManyToOne
	@NonNull @Getter @Setter private Compra compra;

	@ManyToOne
	@NonNull @Getter @Setter private Produto produto;

	@Getter @Setter float quantidade;

	@Getter @Setter float valorUnitario;

	public float getValorTotal() {
		return this.quantidade * this.valorUnitario;
	}


}
