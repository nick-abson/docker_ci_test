package gb.nabs.taxonomyapi;

import com.google.common.base.Predicate;
import gb.nabs.taxonomyapi.division.DivisionController;
import gb.nabs.taxonomyapi.subclass.SubclassController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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
    /*
	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class,
						String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(
						newRule(typeResolver.resolve(DeferredResult.class,
								typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
								typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET,
						newArrayList(new ResponseMessageBuilder()
								.code(500)
								.message("500 message")
								.responseModel(new ModelRef("Error"))
								.build()))
				.securitySchemes(newArrayList(apiKey()))
				.securityContexts(newArrayList(securityContext()))
				.enableUrlTemplating(true)
				.globalOperationParameters(
						newArrayList(new ParameterBuilder()
								.name("someGlobalParameter")
								.description("Description of someGlobalParameter")
								.modelRef(new ModelRef("string"))
								.parameterType("query")
								.required(true)
								.build()))
				.tags(new JCTree.Tag("Pet Service", "All apis relating to pets"))
				.additionalModels(typeResolver.resolve(AdditionalModel.class))
				;
	}
	*/
