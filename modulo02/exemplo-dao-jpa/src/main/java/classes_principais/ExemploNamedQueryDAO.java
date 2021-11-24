package classes_principais;

import dao.ContatoDAO;
import dao.ContatoJPADAOComJPAUtil;
import dao.ContatoJPADAONamedQuery;
import entity.Contato;

import java.util.List;

public class ExemploNamedQueryDAO {
    public static void main(String[] args) {

        //dao.ContatoDAO contatoDAO = new dao.ContatoJDBCDAO();
        //dao.ContatoDAO contatoDAO = new dao.ContatoJPADAO();
        ContatoJPADAONamedQuery contatoDAO = new ContatoJPADAONamedQuery();

        List<Contato> contatos = contatoDAO.getLista();

        for (Contato c : contatos) {
            System.out.println(c);
        }
        System.out.println("---------------------------------");

        contatos = contatoDAO.getListaIniciadosPorNome("João P");

        for (Contato c : contatos) {
            System.out.println(c);
        }

        System.out.println("---------------------------------");

        contatos = contatoDAO.getListaPaginada(2, 1);

        for (Contato c : contatos) {
            System.out.println(c);
        }

    }
}
