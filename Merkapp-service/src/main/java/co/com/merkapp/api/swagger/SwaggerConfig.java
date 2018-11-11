package co.com.merkapp.api.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact CONTACT = new Contact("Juan D. Zapata", "", "jzapat11@gmail.com");
    private static final ApiInfo API_INFO = new ApiInfo(
            "MERKAPP API",
            "API that is going to be exposed to be consumed by mobile and web clients",
            "SNAPSHOT 0.0.1",
            "http://dummy/termsofservice",
            CONTACT,
            "GNU",
            "http://dummy/licenseurl"
    );
    private static final Set<String> CONSUMES_PRODUCES = new HashSet<>(Arrays.asList("application/json"));

    @Bean
    public Docket apiDocumentation() {

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(API_INFO)
            .consumes(CONSUMES_PRODUCES)
            .produces(CONSUMES_PRODUCES);
    }
}
