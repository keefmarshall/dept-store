package uk.co.eleusis.deptstore.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.Log4jConfigListener;

/**
 * In theory, this replaces the web.xml file in servlet 3.0/3.1 containers, and configures
 * the Spring DispatcherServlet.
 * 
 * @author keithm
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses() 
    {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() 
    {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() 
    {
        return new String[] { "/*" };
    }
    
    // Log4J config:
    @Override
    public void onStartup(ServletContext container) throws ServletException 
    {
        Log4jConfigListener log4jConfigListener = new Log4jConfigListener();
        container.addListener(log4jConfigListener);
        super.onStartup(container);
    }
}