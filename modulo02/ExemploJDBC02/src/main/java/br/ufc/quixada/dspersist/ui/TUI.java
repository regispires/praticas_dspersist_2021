package br.ufc.quixada.dspersist.ui;

import br.ufc.quixada.dspersist.dao.ConnectionFactory;
import br.ufc.quixada.dspersist.dao.ContatoDAO;
import br.ufc.quixada.dspersist.dao.ContatoDAOJDBC;
import br.ufc.quixada.dspersist.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = new ContatoDAOJDBC();
        List<Contato> contatos = contatoDAO.findAll();
        for (Contato c : contatos) {
            System.out.println(c);
        }
    }
}
