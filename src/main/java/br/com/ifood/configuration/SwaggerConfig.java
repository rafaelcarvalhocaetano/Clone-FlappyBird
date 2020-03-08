package br.com.ifood.configuration;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configurable
public class SwaggerConfig {


  @Bean
  public Docket forumApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("br.com.ifood"))
      .paths(PathSelectors.ant("/**"))
      .build()
      .apiInfo(apiInfo())
      .globalOperationParameters(Arrays.asList(
        new ParameterBuilder()
          .name("Authorization")
          .description("Header para token JWT")
          .modelRef(new ModelRef("string"))
          .required(false)
          .build()
      ));
  }

private ApiInfo apiInfo() {
	return new ApiInfo(
    "IFOOD", 
    "Api IFood",
    "v1",
    "termsOfServiceUrl",
    new Contact("Rafael", "url-github", "rapha.pse@outlook.com"), 
    "license", "License of URL", Collections.emptyList());
}  
}