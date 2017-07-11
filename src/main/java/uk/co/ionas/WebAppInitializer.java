package uk.co.ionas;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger LOGGER = LogManager.getRootLogger();
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOGGER.info("WebApp initializing...");
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(this.getClass().getName());
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		final ServletRegistration.Dynamic dispatcher = servletContext
				.addServlet("dispatcherServlet", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		servletContext.addListener(new ContextLoaderListener(context));
	}
	
}