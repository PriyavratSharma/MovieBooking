package com.capgemini.onlinemoviebooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static springfox.documentation.builders.PathSelectors.regex;

import org.modelmapper.ModelMapper;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
    public Docket version1() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.capgemini.onlinemoviebooking.controller"))
                .paths(regex(".*" + ".*")).build().enable(true)
                .groupName("Online movie ticket system")
                .apiInfo(new ApiInfoBuilder().description("Online Movie Booking APIs")
                        .title("Online Movie Booking APIs").version("1.0.0.0").build());
}
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setAmbiguityIgnored(true);
        return modelMapper;
    }
}
