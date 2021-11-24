package entity;

import javax.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

}
