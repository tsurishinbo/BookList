package dao;

import entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class MCategoryDao {
 
    @PersistenceContext
    private EntityManager em;

    public MCategoryDao() { }

    public List<MCategory> findAll() {
        Query query = em.createNamedQuery("MCategory.findAll");
        List<MCategory> list = query.getResultList();
        return list;
    }
}
