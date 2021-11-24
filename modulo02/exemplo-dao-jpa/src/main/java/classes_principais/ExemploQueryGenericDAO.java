package classes_principais;

import dao.GenericDAO;
import dao.GenericJPADAO;
import entity.Contato;

import java.util.List;

public class ExemploQueryGenericDAO {
    public static void main(String[] args) {
        GenericDAO<Contato> contatoDAO = new GenericJPADAO<Contato>(Contato.class);
        List<Contato> contatos = contatoDAO.find();

        for (Contato c : contatos) {
            System.out.println(c);
        }

    }
}
