package spitter.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spitter.web")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * Configure a JSP view resolver
     *
     * it’s configured to look for JSP files by wrapping
     * view names with a specific prefix and suffix
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
    }

    /**
     * Configure JSP layout
     *
     * It loads tile definitions and coordinates with Apache Tiles,
     * @return
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {
                "/WEB-INF/layout/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }


    /**
     * Configure static content handling
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource =
                new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
