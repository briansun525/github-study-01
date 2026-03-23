package org.owasp.benchmark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("/")
                .setCachePeriod(0);

        registry.addResourceHandler("/benchmark/**")
                .addResourceLocations("/")
                .setCachePeriod(0);
    }
}
