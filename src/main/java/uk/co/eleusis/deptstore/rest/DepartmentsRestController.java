package uk.co.eleusis.deptstore.rest;

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

import uk.co.eleusis.deptstore.data.Department;
import uk.co.eleusis.deptstore.data.DepartmentDao;
import uk.co.eleusis.deptstore.data.ItemDao;

@Controller
@ExposesResourceFor(Department.class)
@RequestMapping("/departments")
public class DepartmentsRestController
{
	private static final Logger LOG = 
			Logger.getLogger(DepartmentsRestController.class.getName());
	
	@Autowired DepartmentDao departmentDao;
	@Autowired ItemDao itemDao;
	
	@RequestMapping(value = "/{department}", 
			method=RequestMethod.GET,
			produces="application/json")
	public Department getDepartment(@PathVariable String department)
	{
		Department dept = departmentDao.get(department);
		setSelfRel(dept);
		return dept;
	}

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public List<Department> getDepartments()
	{
		List<Department> departments = departmentDao.getAll();
		for (Department dept : departments)
		{
			setSelfRel(dept);
		}
		return departments;
	}

	@RequestMapping(method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = "application/json")
	public Department addDepartment(@RequestBody Department department)
	{
		departmentDao.save(department);
		return department;
	}
	
	// TODO: /departments/electricals/items/television etc
	
	/////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////
	// PRIVATE METHODS
	
	private void setSelfRel(Department ft)
	{
		ft.add(linkTo(this.getClass()).slash(ft.getName()).withSelfRel());
	}
}
