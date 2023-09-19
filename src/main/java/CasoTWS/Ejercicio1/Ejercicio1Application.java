package CasoTWS.Ejercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// import CasoTWS.Ejercicio1.conig.SwaggerConfig;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableSwagger2
public class Ejercicio1Application {
	// @Bean
	// public Docket api(){
	// 	return new Docket(DocumentationType.SWAGGER_2)
	// 		.select()
	// 		.apis(RequestHandlerSelectors.any())
	// 		.paths(PathSelectors.any())
	// 		.build();
	// }

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	    // SpringApplication application = new SpringApplication(Ejercicio1Application.class);
    // application.addListeners(new SwaggerConfig());
    // application.run(args);
}
}
