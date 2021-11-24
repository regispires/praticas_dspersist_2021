package dao;

import entity.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ContatoJPADAO implements ContatoDAO {
    public void adiciona(Contato contato) {
        EntityManager em = Persistence.createEntityManagerFactory("dev")
                .createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(contato);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Contato> getLista() {
        EntityManager em = Persistence.createEntityManagerFactory("dev")
                .createEntityManager();
        List<Contato> l = em.createQuery("select c from Contato as c", Contato.class).getResultList();
        em.close();
        return l;
    }

    public List<Contato> getListaPaginada(int pagina, int tamanhoPagina) {
        return null;
    }

}

