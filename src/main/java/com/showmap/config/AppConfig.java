package com.showmap.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by WYKIM on 2017-06-19.
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ConfigurationProperties(locations="classpath:application.yml", prefix = "spring.resources")
public class AppConfig extends WebMvcConfigurerAdapter {
    private String staticLocations;
    private Integer cachePeriod;
    public Integer getCachePeriod() {
        return cachePeriod;
    }
    public void setCachePeriod(Integer cachePeriod) {
        this.cachePeriod = cachePeriod;
    }
    public String getStaticLocations() {
        return staticLocations;
    }
    public void setStaticLocations(String staticLocations) {
        this.staticLocations = staticLocations;
    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .useJaf(true)
                .favorPathExtension(true)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        ResourceHandlerRegistration staticResource = registry.addResourceHandler("/static/**")
                .addResourceLocations(getStaticLocations());
        if(getCachePeriod() != null){
            staticResource.setCachePeriod(getCachePeriod());
        }
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        return new MappingJackson2HttpMessageConverter();
    }


}
