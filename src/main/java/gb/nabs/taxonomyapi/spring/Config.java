package gb.nabs.taxonomyapi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
// spring boot automaticall reads application.properites (any profile.properties will override properties)
//@PropertySource({ "classpath:application.properties" })

public class Config {

    @Autowired
    private Environment env;

    // configs
}
