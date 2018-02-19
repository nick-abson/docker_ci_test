package gb.nabs.taxonomyapi.service;

import gb.nabs.taxonomyapi.db.repository.SubclassRepository;
import gb.nabs.taxonomyapi.db.model.Subclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Repository
public class SubclassService implements SubclassRepository {

    private final JdbcTemplate jdbcTemplate ;
    private final DivisionService divisionService;

    @Autowired
    public SubclassService (JdbcTemplate jdbcTemplate, DivisionService divisionService)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.divisionService=divisionService;
    };


    @Override
    public List<Subclass> findAll(String divisionId) {

        String sql = "SELECT id, division_id, name, description FROM subclass WHERE division_id = ?";

        RowMapper<Subclass> rowMapper = new BeanPropertyRowMapper<Subclass>(Subclass.class);

        return this.jdbcTemplate.query(sql, rowMapper, divisionId);
    }

    @Override
    public Subclass findById(String id) {

        String sql = "SELECT id, name, division_id, description FROM subclass where id = ? ";

        RowMapper<Subclass> rowMapper = new BeanPropertyRowMapper<Subclass>(Subclass.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // add or replace subclass
    @Override
    public void save(Subclass subclass) {
        String sql = "INSERT INTO subclass (id, division_id, name, description) VALUES (?,?,?,?) " +
                "ON CONFLICT (id,division_id) DO UPDATE " +
                "SET name = EXCLUDED.name, description = EXCLUDED.description";
        this.jdbcTemplate.update(sql, subclass.getId(), subclass.getDivision().getId(), subclass.getName(), subclass.getName());
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM subclass WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }
}
