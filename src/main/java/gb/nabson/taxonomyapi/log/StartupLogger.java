package gb.nabson.taxonomyapi.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class StartupLogger implements InitializingBean {
    private static final String ACTIVE_SPRING_PROFILE_KEY = "config.profiles.active";
    private static final String DB_URL_KEY = "spring.datasource.url";
    private static final String DB_USER_KEY = "spring.datasource.username";
    private static final String SERVER_PORT = "server.port";
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Environment env;

    public StartupLogger() {
        super();
    }

    @Override
    public void afterPropertiesSet() {


        logger.info("============================================================================");
        logger.info("{} = {}", ACTIVE_SPRING_PROFILE_KEY, env.getProperty(ACTIVE_SPRING_PROFILE_KEY));
        logger.info("{} = {}", DB_URL_KEY, env.getProperty(DB_URL_KEY));
        logger.info("{} = {}", DB_USER_KEY, env.getProperty(DB_USER_KEY));
        logger.info("{} = {}", SERVER_PORT, env.getProperty(SERVER_PORT));
        logger.info("============================================================================");
    }

}

