package uk.co.eleusis.deptstore.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.objectdb.o._NoResultException;

/**
 * This handles exceptions from ObjectDB, no matter which controller.
 * 
 * It means, at least, that the ObjectDB dependencies can be kept encapsulated away
 * from the main controllers. I still don't really like having hard class dependencies on
 * ObjectDB - this is the only place we reference ObjectDB classes directly in the whole
 * codebase - otherwise it's done through the persistence.xml file.
 * 
 * @author keithm
 *
 */
@ControllerAdvice
public class ObjectDBExceptionHandler 
{
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Requested object not found")
	@ExceptionHandler(_NoResultException.class)
	public void handleItemNotFoundException()
	{
		// no-op
	}
}
