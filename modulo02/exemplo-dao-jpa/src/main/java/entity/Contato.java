package entity;

import javax.persistence.*;

@NamedQuery(name="Contato.findAll", query="select c from Contato as c")
@NamedQuery(name="Contato.findByIniciadosPorNome", query="select c from Contato as c where c.nome like :nome")

@Entity
@Table(name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String endereco;

    public Contato() {}

    public Contato(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public Contato(Integer id, String nome, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "entity.Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
