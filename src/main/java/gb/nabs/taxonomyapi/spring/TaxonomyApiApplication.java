package gb.nabs.taxonomyapi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = { "gb.nabs.taxonomyapi" })
@Import({ // @formatter:off
		Config.class
}) // @formatter:on

public class TaxonomyApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxonomyApiApplication.class, args);
	}
}




