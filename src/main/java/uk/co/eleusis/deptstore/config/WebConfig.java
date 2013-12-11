package uk.co.eleusis.deptstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Spring servlet context configuration
 * [replaces deptstore-servlet.xml]
 * 
 * @author keithm
 *
 */
@Configuration
@ComponentScan({"uk.co.eleusis.deptstore.rest"})
@EnableWebMvc
@EnableHypermediaSupport
public class WebConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) 
	{
		configurer.favorPathExtension(false).favorParameter(true);
		configurer.mediaTypes(ImmutableMap.of(
				"json", MediaType.APPLICATION_JSON,
				"html", MediaType.TEXT_HTML
				));
	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver()
	{
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(ImmutableList.of(urlBasedViewResolver()));
		resolver.setDefaultViews(ImmutableList.of(mappingJacksonJsonView()));
		return resolver;
	}

	@Bean
	public ViewResolver urlBasedViewResolver() 
	{
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public View mappingJacksonJsonView()
	{
		MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
		jsonView.setExtractValueFromSingleKeyModel(true);
		jsonView.setPrettyPrint(true);
		return jsonView;
	}
}
