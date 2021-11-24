package dao;

import entity.Contato;

import java.util.List;

public interface ContatoDAO {
    void adiciona(Contato contato);

    List<Contato> getLista();

    List<Contato> getListaPaginada(int pagina, int tamanhoPagina);
}
