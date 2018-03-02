package gb.nabson.taxonomy.app.service;

import gb.nabson.taxonomy.app.api.model.Division;
import gb.nabson.taxonomy.app.api.model.DivisionList;
import gb.nabson.taxonomy.app.api.model.Subclass;
import gb.nabson.taxonomy.app.api.model.SubclassList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    private RestTemplate restTemplate;

    private final String api_url;


    @Autowired
    public ApiService(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
//    public ApiService(RestTemplate restTemplate, @Value("${api.url}") String api_url, @Value("${subclass.url}") String subclass_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    public SubclassList getSubclasses(String divisionId) {
        String url = String.format("%s/%s/subclasses", api_url,divisionId);

        //todo add pagination
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(url);


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SubclassList> responseEntity =
                restTemplate.getForEntity(uriBuilder.toUriString(),SubclassList.class);
        return responseEntity.getBody();
    }
    public DivisionList getDivisions() {

        //todo add pagination
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<DivisionList> responseEntity =
                restTemplate.getForEntity(uriBuilder.toUriString(),DivisionList.class);
        return responseEntity.getBody();
    }
    public Division getDivision(String divisionId) {
        String url = String.format("%s/%s", api_url,divisionId);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Division> responseEntity =
                restTemplate.getForEntity(url,Division.class);
        return responseEntity.getBody();
    }
}
