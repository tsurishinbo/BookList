package dao;

import entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class TBookDao {
    
    @PersistenceContext
    private EntityManager em;
    
    public TBookDao() { }
    
    public List<TBook> findAll() {
        Query query = em.createNamedQuery("TBook.findAll");
        List<TBook> list = query.getResultList();
        return list;
    }
    
    public TBook findById(int id) {
        Query query = em.createNamedQuery("TBook.findById");
        query.setParameter("id", id);
        try {
            TBook book = (TBook)query.getSingleResult();
            return book;
        } catch (javax.persistence.NoResultException e ) {
            return null;
        }
    }
    
    public void insert(TBook book) {
        em.persist(book);
        em.flush();
        em.clear();
    }
    
    public void update(TBook book) {
        em.merge(book);
        em.flush();
        em.clear();
    }
}
