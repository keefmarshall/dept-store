package uk.co.eleusis.deptstore.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Item extends ResourceSupport
{
	@Id
	private String name;
	
	@ManyToOne
	private Department department;

	public Item() {}
	
	
	public Item(String name, Department department) 
	{
		this.name = name;
		this.department = department;
	}


	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	// SETTERS / GETTERS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
