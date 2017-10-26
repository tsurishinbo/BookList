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
            return (TBook)query.getSingleResult();
        } catch (javax.persistence.NoResultException e ) {
            return null;
        }
    }
    
    public void update(TBook book) {
        em.merge(book);
    }
}
