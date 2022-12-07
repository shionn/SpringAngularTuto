package tuto;

import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
		super.onStartup(servletContext);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfig.class, };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

	@EnableWebMvc
	@Configuration
	@ComponentScan({ "tuto" })
	// @PropertySource("classpath:configuration.properties")
	public static class WebMvcConfig implements WebMvcConfigurer {
//		@Bean
//		public InternalResourceViewResolver viewResolver() {
//			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//			viewResolver.setViewClass(JstlView.class);
//			viewResolver.setPrefix("/WEB-INF/static/");
//			viewResolver.setSuffix(".html");
//			return viewResolver;
//		}
//
//		@Bean(name = "multipartResolver")
//		public CommonsMultipartResolver getResolver() throws IOException {
//			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//			resolver.setMaxUploadSizePerFile(1024 * 1024);// 1MB
//			return resolver;
//		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		}
//
	}
}
