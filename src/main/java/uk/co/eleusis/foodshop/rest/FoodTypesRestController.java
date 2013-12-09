package uk.co.eleusis.foodshop.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.eleusis.foodshop.data.FoodDao;
import uk.co.eleusis.foodshop.data.FoodType;
import uk.co.eleusis.foodshop.data.FoodTypeDao;

@Controller
@ExposesResourceFor(FoodType.class)
@RequestMapping("/foodtypes")
public class FoodTypesRestController
{
	private static final Logger LOG = 
			Logger.getLogger(FoodTypesRestController.class.getName());
	
	@Autowired FoodTypeDao foodTypeDao;
	@Autowired FoodDao foodDao;
	
	@RequestMapping(value = "/{foodtype}", 
			method=RequestMethod.GET,
			produces="application/json")
	public FoodType getFoodType(@PathVariable String foodtype)
	{
		FoodType ft = foodTypeDao.get(foodtype);
		setSelfRel(ft);
		return ft;
	}

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<FoodType> getFoodTypes()
	{
		List<FoodType> foodTypes = foodTypeDao.getAll();
		for (FoodType ft : foodTypes)
		{
			setSelfRel(ft);
		}
		return foodTypes;
	}

	@RequestMapping(method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = "application/json")
	public FoodType addFoodType(@RequestBody FoodType foodType)
	{
		foodTypeDao.save(foodType);
		return foodType;
	}
	
	// TODO: /foodtypes/fruit/foods/apple etc
	
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	// PRIVATE METHODS
	
	private void setSelfRel(FoodType ft)
	{
		ft.add(linkTo(this.getClass()).slash(ft.getType()).withSelfRel());
	}
}
