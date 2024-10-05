package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.jms.support.converter.SimpleMessageConverter;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors; 
//import springfox.documentation.builders.RequestHandlerSelectors; 
//import springfox.documentation.spi.DocumentationType; 
//import springfox.documentation.spring.web.plugins.Docket; 

@Configuration
public class SwaggerConfig { 

//	public Docket SwaggerApi() { 
//		return new Docket(DocumentationType.SWAGGER_2) 
//			.select() 
//			.apis(RequestHandlerSelectors.any()) 
//			.paths(PathSelectors.any()) 
//			.build(); 
//	}
	
//	public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any()) 
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Spring Boot REST API Documentation")
//                        .description("API documentation for Spring Boot application")
//                        .version("1.0")
//                        .build());
//    }
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot REST API Documentation")
                        .version("1.0")
                        .description("API documentation for Spring Boot application"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }
    
    @Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
    
//	   @Bean
//	   MessageConverter converter(){
//		   return new SimpleMessageConverter();
//	   }
}

