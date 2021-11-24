package dao;

import entity.Contato;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ContatoJPADAONamedQuery implements ContatoDAO {
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
        List<Contato> l = em.createNamedQuery("Contato.findAll").getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Contato> getListaIniciadosPorNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Contato> l = em.createNamedQuery("Contato.findByIniciadosPorNome")
                .setParameter("nome", nome + "%")
                .getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

    public List<Contato> getListaPaginada(int pagina, int tamanhoPagina) {
        EntityManager em = JPAUtil.getEntityManager();
        int offset = (pagina - 1) * tamanhoPagina;
        List<Contato> l = em.createNamedQuery("Contato.findAll").setFirstResult(offset).setMaxResults(tamanhoPagina).getResultList();
        JPAUtil.closeEntityManager();
        return l;
    }

}

