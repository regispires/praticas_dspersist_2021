package classes_principais;

import dao.ContatoDAO;
import dao.ContatoJPADAOComJPAUtil;
import entity.Contato;

public class ExemploInsertDAO {
    public static void main(String[] args) {
        //dao.ContatoDAO contatoDAO = new dao.ContatoJDBCDAO();
        //dao.ContatoDAO contatoDAO = new dao.ContatoJPADAO();
        ContatoDAO contatoDAO = new ContatoJPADAOComJPAUtil();

        Contato c = new Contato("João Pedro", "joaopedro@gmail.com", "R. João 123");
        contatoDAO.adiciona(c);
    }
}
