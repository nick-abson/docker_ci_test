package gb.nabson.taxonomy.api;

import gb.nabson.taxonomy.api.config.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = { "gb.nabson.taxonomy.api" })
@Import({ // @formatter:off
		AppConfiguration.class
}) // @formatter:on

public class TaxonomyApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxonomyApiApplication.class, args);
	}
}




