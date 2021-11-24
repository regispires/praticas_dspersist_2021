package dao;

import entity.Contato;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ContatoJPADAOComJPAUtil implements ContatoDAO {
    public void adiciona(Contato contato) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            JPAUtil.beginTransaction();
            em.merge(contato);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Contato> getLista() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Contato> l = em.createQuery("select c from Contato as c", Contato.class).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Contato> getListaPaginada(int pagina, int tamanhoPagina) {
        return null;
    }

}

