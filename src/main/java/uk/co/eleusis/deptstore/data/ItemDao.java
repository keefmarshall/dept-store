package uk.co.eleusis.deptstore.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ItemDao 
{
    // Injected database connection:
    @PersistenceContext private EntityManager em;
	 
    @Transactional
    public void save(Item item)
    {
    	em.persist(item);
    }

    @Transactional
    public List<Item> getAll()
    {
    	TypedQuery<Item> query = em.createQuery(
    			"SELECT i FROM Item i ORDER BY i.name", Item.class);
    	
    	return query.getResultList();
    }
    
    @Transactional
    public Item get(String name)
    {
    	TypedQuery<Item> query = em.createQuery(
    			"SELECT i FROM Item i WHERE i.name = :name", Item.class);
    	query.setParameter("name", name);
    	
    	return query.getSingleResult();
    }

    @Transactional
    public void delete(String name)
    {
    	em.remove(get(name));
    }
    
    @Transactional
    public List<Item> getByDepartment(Department department)
    {
    	TypedQuery<Item> query = em.createQuery(
    			"SELECT i FROM Item i WHERE i.department = :department", Item.class);
    	query.setParameter("department", department);
    	
    	return query.getResultList();
    }
}
