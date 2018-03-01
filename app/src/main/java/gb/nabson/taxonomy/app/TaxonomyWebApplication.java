package gb.nabson.taxonomy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "gb.nabson.taxonomy.app" })
public class TaxonomyWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaxonomyWebApplication.class, args);
	}
}




