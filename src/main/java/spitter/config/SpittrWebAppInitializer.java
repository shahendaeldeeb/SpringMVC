package spitter.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Any class that extends AbstractAnnotationConfigDispatcherServletInitializer
 * will automatically be used to configure DispatcherServlet and the Spring
 * application context in the application’s servlet context.
 */
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Map DispatcherServlet to /
     *
     * indicating that it will be the application’s default servlet.
     * It will handle all requests coming into the application.
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/spittr/uploads"));
    }
    /**
     * Specify configuration class
     *
     * you’ve asked that DispatcherServlet load its application context
     * with beans defined in the WebConfig configuration class
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
}
