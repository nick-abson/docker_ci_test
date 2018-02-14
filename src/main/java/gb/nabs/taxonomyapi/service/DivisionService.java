package gb.nabs.taxonomyapi.service;


import gb.nabs.taxonomyapi.db.dao.DivisionDAO;
import gb.nabs.taxonomyapi.db.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// tell spring to create a single instance
// in spring a business service is usually a singleton
// when the application starts, Spring starts a single instance and registers it as a service
// other classes can inject the service - to do this Spring will scan for @Autowired
@Service
public class DivisionService implements DivisionDAO {

    //Inject the JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Division> getAllDivisions() {
        List<Division> divisions = new ArrayList<>();

        String sql = "SELECT id, name, description FROM division";

        // you can create a class that implements RowMapper  to map class properties to  columns
        //use BeanPropertyRowMapper when properties and columns are named the same
        RowMapper<Division> rowMapper = new BeanPropertyRowMapper<Division>(Division.class);

        return this.jdbcTemplate.query(sql, rowMapper);

    }

    public Division getDivision(String id) {

        String sql = "SELECT id, name, description FROM division where id = ? ";

        RowMapper<Division> rowMapper = new BeanPropertyRowMapper<Division>(Division.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // add or replace a resource
    public void addDivision(Division division) {

        //TODO check ID was supplied in body - http error code if not
        String sql = "INSERT INTO division (id, name, description) VALUES (?,?,?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET name = EXCLUDED.name, description = EXCLUDED.description";
        this.jdbcTemplate.update(sql, division.getId(), division.getName(), division.getName());
    }

    // save a resource where you know the resource uri
    public void updateDivision(Division division, String id) {
        // ignore any id supplied in the body of the request
        division.setId(id);
        this.addDivision(division);
    }

    public void deleteDivision(String id) {
        String sql = "DELETE FROM subclass WHERE division_id = ?";
        this.jdbcTemplate.update(sql, id);

        sql = "DELETE FROM division WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }
}
