package gb.nabson.taxonomyapi;

import gb.nabson.taxonomyapi.config.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = { "gb.nabson.taxonomyapi" })
@Import({ // @formatter:off
		AppConfiguration.class
}) // @formatter:on

public class TaxonomyApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxonomyApiApplication.class, args);
	}
}




