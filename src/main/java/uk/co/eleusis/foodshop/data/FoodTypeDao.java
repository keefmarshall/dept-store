package uk.co.eleusis.foodshop.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Data access for FoodType object
 * 
 * @author keithm
 *
 */
@Component
public class FoodTypeDao 
{
    // Injected database connection:
    @PersistenceContext private EntityManager em;
	 
    @Transactional
    public void save(FoodType foodtype)
    {
    	em.persist(foodtype);
    }

    @Transactional
    public List<FoodType> getAll()
    {
    	TypedQuery<FoodType> query = em.createQuery(
    			"SELECT f FROM FoodType f ORDER BY f.type", FoodType.class);
    	
    	return query.getResultList();
    }
    
    @Transactional
    public FoodType get(String type)
    {
    	TypedQuery<FoodType> query = em.createQuery(
    			"SELECT f FROM FoodType f WHERE f.type = :type", FoodType.class);
    	query.setParameter("type", type);
    	
    	return query.getSingleResult();
    }
}
