package br.ufc.quixada.ui;

import br.ufc.quixada.dao.ClienteDAO;
import br.ufc.quixada.dao.ProdutoDAO;
import br.ufc.quixada.entity.Cliente;
import br.ufc.quixada.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan("br.ufc.quixada")
public class ListaClientes implements CommandLineRunner {
    @Autowired
    private ClienteDAO clienteDAO;

    public void run(String[] args) {
        List<Cliente> clientes = clienteDAO.findAll();
        for (Cliente cli : clientes) {
            System.out.println(cli);
        }
    }
}
