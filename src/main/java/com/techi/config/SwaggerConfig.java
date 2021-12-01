package com.techi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	//http://localhost:8080/swagger-ui/  : Request in chrome or MSEdge
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.techi"))
				.paths(PathSelectors.any())
				.build();
		
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Techi API")
				.description("It is only for Developers")
				.termsOfServiceUrl("https://www.google.com")
				//.contact("skaleeminfo@gmail.com")
				.license("Techi IT")
				.licenseUrl("skaleeminfo@gmail.com")
				.version("1.0")
				.build();
	}
	
	/*	@Bean
	public Docket apiDoc() {
		
		Docket docket=new Docket(DocumentationType.SWAGGER_2);
		ApiSelectorBuilder apiSelectBuilder=docket.select();
		
		Predicate<RequestHandler> predicate=RequestHandlerSelectors.basePackage("com.techi");
		
		ApiSelectorBuilder apiSelectBuilder2=apiSelectBuilder.apis(predicate);
		
		Predicate<String> predicateAny=PathSelectors.any();
		
		ApiSelectorBuilder apiSelectorBuilder3=apiSelectBuilder2.paths(predicateAny);
		
		Docket docketbuilder=apiSelectorBuilder3.build();
		return docketbuilder;	
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.techi")).paths(PathSelectors.any()).build();
	}*/
}