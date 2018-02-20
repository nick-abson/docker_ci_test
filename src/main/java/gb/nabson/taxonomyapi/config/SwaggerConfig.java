package gb.nabson.taxonomyapi.config;

import com.google.common.base.Predicate;
import gb.nabson.taxonomyapi.web.controller.DivisionController;
import gb.nabson.taxonomyapi.web.controller.SubclassController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration

//swagger from springfox
@EnableSwagger2
// API controller classes to be scanned by springfox
@ComponentScan(basePackageClasses = {
        DivisionController.class,
        SubclassController.class
})
public class SwaggerConfig {
    //initialize springfox config
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                // control endpoints exposed via swagger
                .select()
                // endpoints to be selected
                .paths(paths())

                // build the selector
                .build()
                .apiInfo(metaData());
    }

    // endpoints to be included
    private Predicate<String> paths() {
        return or(
                regex("/divisions.*")
        );
    }


    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "demo API ",
                "taxononmy api to test docker/jenkins",
                "1.0",
                "",
                 "nabs",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0" );

        return apiInfo;
    }
}

