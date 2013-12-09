package uk.co.eleusis.foodshop.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FoodDao 
{
    // Injected database connection:
    @PersistenceContext private EntityManager em;
	 
    @Transactional
    public void save(Food food)
    {
    	em.persist(food);
    }

    @Transactional
    public List<Food> getAll()
    {
    	TypedQuery<Food> query = em.createQuery(
    			"SELECT f FROM Food f ORDER BY f.name", Food.class);
    	
    	return query.getResultList();
    }
    
    @Transactional
    public Food get(String name)
    {
    	TypedQuery<Food> query = em.createQuery(
    			"SELECT f FROM Food f WHERE f.type = :type", Food.class);
    	query.setParameter("name", name);
    	
    	return query.getSingleResult();
    }

}
