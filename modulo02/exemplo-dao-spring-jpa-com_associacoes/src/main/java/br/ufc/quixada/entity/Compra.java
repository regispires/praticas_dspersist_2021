package br.ufc.quixada.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;

	@ManyToOne
	@Getter @Setter private Cliente cliente;

	@NonNull @Getter @Setter private LocalDateTime dataHora;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
	@Getter @Setter private List<ItemCompra> itens;

	public float getValorTotal() {
		float total = 0;
		for (ItemCompra item: this.itens) {
			total += item.getValorTotal();
		}
		return total;
	}

}
