package uk.co.eleusis.deptstore.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.eleusis.deptstore.data.Department;
import uk.co.eleusis.deptstore.data.Item;
import uk.co.eleusis.deptstore.data.ItemDao;

@Controller
@ExposesResourceFor(Item.class)
@RequestMapping("/departments/{department}/items")
public class ItemsByDepartmentRestController 
{
	@Autowired private ItemDao itemDao;
	@Autowired private RelHelper relHelper;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	public Item getItem(@PathVariable String id)
	{
		Item item = itemDao.get(id);
		relHelper.setSelfRel(item);
		return item;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces="application/json")
	public void deleteItem(@PathVariable String id)
	{
		itemDao.delete(id);
	}

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<Item> getItems(@PathVariable Department department)
	{
		List<Item> items = itemDao.getByDepartment(department);
		for (Item item : items)
		{
			relHelper.setSelfRel(item);
		}
		return items;
	}

	@RequestMapping(
			method=RequestMethod.POST, 
			produces="application/json", 
			consumes="application/json")
	public Item addItem(@PathVariable Department department,
						@RequestBody Item item)
	{
		item.setDepartment(department);
		itemDao.save(item);
		
		// Set links for return value:
		relHelper.setSelfRel(item);
		
		return item;
	}

}
