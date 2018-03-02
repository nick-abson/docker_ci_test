package gb.nabson.taxonomy.api.bootstrap;

import gb.nabson.taxonomy.api.model.Division;
import gb.nabson.taxonomy.api.model.Subclass;
import gb.nabson.taxonomy.api.repository.DivisionRepository;
import gb.nabson.taxonomy.api.repository.SubclassRepository;
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

@Component
@Profile("dev")
public class TestData implements ApplicationListener<ContextRefreshedEvent> {
    private static final String ACTIVE_SPRING_PROFILE_KEY = "spring.profiles.active";


    private DivisionRepository divisionRepository;
    private SubclassRepository subclassRepository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

    @Autowired
    public TestData(DivisionRepository divisionRepository, SubclassRepository subclassRepository) {
        this.divisionRepository= divisionRepository;
        this.subclassRepository = subclassRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        logger.info("============================================================================");
        logger.info("creating test data for active profile: {}",  env.getProperty(ACTIVE_SPRING_PROFILE_KEY));
        loadDevData();
        logger.info("============================================================================");

    }
    public void loadDevData() {

        Division divisionA = new Division("lathyrus","vetches(DEV)","Genus: Lathyrus");
        Subclass subclassA1 = new Subclass ("aphaca","lathyrus(DEV)","yellow pea vetch",divisionA);
        Subclass subclassA2 = new Subclass ("aureus","lathyrus(DEV)","golden pea vetch",divisionA);
        divisionRepository.save(divisionA);
        subclassRepository.save(subclassA1);
        subclassRepository.save(subclassA2);

        Division divisionB = new Division ("pisum","peas(DEV)","pisum");
        Subclass subclassB1 = new Subclass ("vulnum","pisum(DEV)", "garden pea ", divisionB);
        Subclass subclassB2 = new Subclass ("fulvum","pisum(DEV)", "climbing pea ", divisionB);
        divisionRepository.save(divisionB);
        subclassRepository.save(subclassB1);
        subclassRepository.save(subclassB2);

    }
    public void loadItData() {

        Division divisionA = new Division("lathyrus","vetches(IT)","Genus: Lathyrus");
        Subclass subclassA1 = new Subclass ("aphaca","lathyrus(IT)","yellow pea vetch",divisionA);
        Subclass subclassA2 = new Subclass ("aureus","lathyrus(IT)","golden pea vetch",divisionA);
        divisionRepository.save(divisionA);
        subclassRepository.save(subclassA1);
        subclassRepository.save(subclassA2);

        Division divisionB = new Division ("pisum","peas(IT)","pisum");
        Subclass subclassB1 = new Subclass ("vulnum","pisum(IT)", "garden pea ", divisionB);
        Subclass subclassB2 = new Subclass ("fulvum","pisum(IT)", "climbing pea ", divisionB);
        divisionRepository.save(divisionB);
        subclassRepository.save(subclassB1);
        subclassRepository.save(subclassB2);

    }
}
