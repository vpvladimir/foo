package vp.filmography.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//return new Class[0];
		return new Class[]{HibernateConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
	protected javax.servlet.Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return (javax.servlet.Filter[]) new Filter[] {(Filter) characterEncodingFilter};
    }
    
}
