package gb.nabs.taxonomyapi;

import com.sun.tools.javac.tree.JCTree;
import gb.nabs.taxonomyapi.division.DivisionController;
import gb.nabs.taxonomyapi.subclass.SubclassController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.WildcardType;
import java.time.LocalDate;

@SpringBootApplication
public class TaxonomyApiDbApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxonomyApiDbApplication.class, args);
	}
}




