package br.ufc.quixada.dspersist.ui;

import br.ufc.quixada.dspersist.dao.ContatoDAO;
import br.ufc.quixada.dspersist.dao.ContatoDAOJDBC;
import br.ufc.quixada.dspersist.model.Contato;

import javax.swing.*;
import java.util.List;

public class Principal2 {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = new ContatoDAOJDBC();
        List<Contato> contatos = contatoDAO.findAll();
        StringBuffer sb = new StringBuffer();
        for (Contato c : contatos) {
            sb.append(c);
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb);
    }
}
