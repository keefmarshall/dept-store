package uk.co.eleusis.deptstore.data;

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
public class DepartmentDao 
{
    // Injected database connection:
    @PersistenceContext private EntityManager em;
	 
    @Transactional
    public void save(Department department)
    {
    	em.persist(department);
    }

    @Transactional
    public List<Department> getAll()
    {
    	TypedQuery<Department> query = em.createQuery(
    			"SELECT d FROM Department d ORDER BY d.name", Department.class);
    	
    	return query.getResultList();
    }
    
    @Transactional
    public Department get(String name)
    {
    	TypedQuery<Department> query = em.createQuery(
    			"SELECT d FROM Department d WHERE d.name = :name", Department.class);
    	query.setParameter("name", name);
    	
    	return query.getSingleResult();
    }
}
