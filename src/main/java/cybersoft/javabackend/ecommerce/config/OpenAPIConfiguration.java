package cybersoft.javabackend.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
				.info(new Info()
					.title("E-commerce Application")
					.description("E-commerce Application")
					.version("v1.0")
					.license(new License().name("NO LICENSE").url("https://www.facebook.com/nphuy.107"))
					.contact(new Contact()
	            		  .email("nphuyy1901@gmail.com")
	            		  .name("Nguyen Phuoc Huy")
	            		  .url("https://www.facebook.com/nphuy.107")))
			    .externalDocs(new ExternalDocumentation()
	              .description("Spring Documentation")
	              .url("https://docs.spring.io/spring-framework/docs/current/reference/html/"));

	}
}
