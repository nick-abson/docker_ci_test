package gb.nabs.taxonomyapi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
// spring boot automaticall reads application.properites (any application-<profile>.properties will override  these settings properties)
// set local profile with env variable or -Dspring.profiles.active=local at runtime

public class Config {

    @Autowired
    private Environment env;

    // configs
}
