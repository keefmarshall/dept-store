package uk.co.eleusis.foodshop.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Food extends ResourceSupport
{
	@Id
	private String name;
	
	@ManyToOne
	private FoodType type;

	public Food() {}
	
	
	public Food(String name, FoodType type) 
	{
		this.name = name;
		this.type = type;
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

	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}
}
