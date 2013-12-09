package uk.co.eleusis.foodshop.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class FoodType extends ResourceSupport implements Serializable
{
	private static final long serialVersionUID = -7095315873742997482L;

	@Id
	private String type;
	
	public FoodType()
	{
		
	}
	
	public FoodType(String type)
	{
		this.type = type;
	}

	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	// SETTERS / GETTERS
	
	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	
}
