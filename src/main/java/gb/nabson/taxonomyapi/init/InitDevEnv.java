package gb.nabson.taxonomyapi.init;

import gb.nabson.taxonomyapi.model.Division;
import gb.nabson.taxonomyapi.model.Subclass;
import gb.nabson.taxonomyapi.persistance.repository.DivisionRepository;
import gb.nabson.taxonomyapi.persistance.repository.JdbcSubclassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * load dev data when on dev profile
 */

// make sure class is wired up for config context
@Component
// run for dev profile only
@Profile("dev")
public class InitDevEnv implements ApplicationListener<ContextRefreshedEvent> {
    private static final String ACTIVE_SPRING_PROFILE_KEY = "config.profiles.active";

    private DivisionRepository divisionRepositoryImpl;
    private JdbcSubclassRepository jdbcSubclassRepository;
    private Environment env;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public InitDevEnv(DivisionRepository divisionRepositoryImpl, JdbcSubclassRepository jdbcSubclassRepository, Environment env) {
        this.divisionRepositoryImpl = divisionRepositoryImpl;
        this.jdbcSubclassRepository = jdbcSubclassRepository;
        this.env = env;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        logger.info("============================================================================");
        logger.info("creating data for {} profile: ", env.getProperty(ACTIVE_SPRING_PROFILE_KEY));
        initData();
        logger.info("============================================================================");

    }

    private void initData() {
        Division division = new Division("l1", "level1", "level 1");
        Subclass subclassA = new Subclass("l2a", "level2a", "level 2a", division);
        Subclass subclassB = new Subclass("l2b", "level2b", "level 2b", division);

        divisionRepositoryImpl.save(division);
        jdbcSubclassRepository.save(subclassA);
        jdbcSubclassRepository.save(subclassB);

    }
}
