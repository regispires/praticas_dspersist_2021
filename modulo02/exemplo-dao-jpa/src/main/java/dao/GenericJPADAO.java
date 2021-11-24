package dao;

import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenericJPADAO<T> implements GenericDAO<T> {
    protected Class<T> persistentClass;

    public GenericJPADAO() {}

    public GenericJPADAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void save(T entity) {
        getEm().merge(entity);
    }

    public void delete(T entity) {
        getEm().remove(getEm().merge(entity));
    }

    public T find(Object id) {
        return getEm().find(persistentClass, id);
    }

    public List<T> find() {
        CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(persistentClass);
        cq.from(persistentClass);
        return getEm().createQuery(cq).getResultList();
    }

    public EntityManager getEm() {
        return JPAUtil.getEntityManager();
    }

    public void beginTransaction() {
        JPAUtil.beginTransaction();
    }

    public void commit() {
        JPAUtil.commit();
    }

    public void rollback() {
        JPAUtil.rollback();
    }

    public void close() {
        JPAUtil.closeEntityManager();
    }

}
