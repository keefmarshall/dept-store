package uk.co.eleusis.deptstore.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Department extends ResourceSupport implements Serializable
{
	private static final long serialVersionUID = -7095315873742997482L;

	@Id
	private String name;
	
	public Department()
	{
		
	}
	
	public Department(String name)
	{
		this.name = name;
	}

	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	// SETTERS / GETTERS
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	
}
