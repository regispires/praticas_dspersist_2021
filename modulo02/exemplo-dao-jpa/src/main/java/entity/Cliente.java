package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
