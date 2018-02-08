package gb.nabs.taxonomyapi.subclass;


import gb.nabs.taxonomyapi.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubclassService implements SubclassDAO {

    //Inject the JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DivisionService divisionService;

    public List<Subclass> getAllSubclasses(String divisionId) {
        List<Subclass> subclasss = new ArrayList<>();

        String sql = "SELECT id, division_id, name, description FROM subclass WHERE division_id = ?";

        RowMapper<Subclass> rowMapper = new BeanPropertyRowMapper<Subclass>(Subclass.class);

        return this.jdbcTemplate.query(sql, rowMapper, divisionId);
    }

    public Subclass getSubclass(String id) {

        String sql = "SELECT id, name, division_id, description FROM subclass where id = ? ";

        RowMapper<Subclass> rowMapper = new BeanPropertyRowMapper<Subclass>(Subclass.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // add or replace subclass resource
    public void addSubclass(String divisionId, Subclass subclass) {
        //TODO check division resource exists before attempting insert of subclass
        String sql = "INSERT INTO subclass (id, division_id, name, description) VALUES (?,?,?,?) " +
                "ON CONFLICT (id,division_id) DO UPDATE " +
                "SET name = EXCLUDED.name, description = EXCLUDED.description";
        this.jdbcTemplate.update(sql, subclass.getId(), divisionId, subclass.getName(), subclass.getName());
    }

    // save a resource where you know the resource uri
    public void updateSubclass(String id, String divisionId, Subclass subclass) {
        // update based on id and division_id supplied in the url
        subclass.setId(id);
        subclass.setDivision(divisionService.getDivision(divisionId));
        this.addSubclass(divisionId, subclass);
    }

    public void deleteSubclass(String id) {
        String sql = "DELETE FROM subclass WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }
}
