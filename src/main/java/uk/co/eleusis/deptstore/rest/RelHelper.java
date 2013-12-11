package uk.co.eleusis.deptstore.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

import uk.co.eleusis.deptstore.data.Department;
import uk.co.eleusis.deptstore.data.Item;

/**
 * I'm sure there's some clever way to do this already with the HATEOAS lib, but
 * I haven't quite figured it out yet..
 * 
 * @author keithm
 *
 */
@Component
public class RelHelper 
{
	@Autowired EntityLinks entityLinks;

	public void setSelfRel(Department dept)
	{
		// check if it already has a self-rel:
		if (!dept.hasLink("self"))
		{
			dept.add(entityLinks.linkToSingleResource(Department.class, dept.getName()));
		}
	}

	public void setItemsRel(Department dept)
	{
		if (!dept.hasLink("items"))
		{
			dept.add(linkTo(ItemsByDepartmentRestController.class, dept.getName())
					.withRel("items"));
		}
	}
	
	public void setSelfRel(Item item)
	{
		setSelfRel(item.getDepartment());
		if (!item.hasLink("self"))
		{
			//item.add(entityLinks.linkToSingleResource(Item.class, item.getName()));
			item.add(linkTo(ItemsByDepartmentRestController.class, item.getDepartment().getName()
					).slash(item.getName()).withSelfRel());
		}
	}

}
