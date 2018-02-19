package gb.nabs.taxonomyapi.service;


import gb.nabs.taxonomyapi.db.repository.DivisionRepository;
import gb.nabs.taxonomyapi.db.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements DivisionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DivisionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    ;

    @Override
    public List<Division> findAll() {

        String sql = "SELECT id, name, description FROM division";

        // you can create a class that implements RowMapper  to map class properties to  columns
        //use BeanPropertyRowMapper when properties and columns are named the same
        RowMapper<Division> rowMapper = new BeanPropertyRowMapper<Division>(Division.class);

        return this.jdbcTemplate.query(sql, rowMapper);

    }


    @Override
    public Division findById(String id) {

        String sql = "SELECT id, name, description FROM division where id = ? ";

        RowMapper<Division> rowMapper = new BeanPropertyRowMapper<Division>(Division.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    // add or replace a resource
    @Override
    public void save(Division division) {

        //TODO check ID was supplied in body - http error code if not
        String sql = "INSERT INTO division (id, name, description) VALUES (?,?,?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET name = EXCLUDED.name, description = EXCLUDED.description";
        this.jdbcTemplate.update(sql, division.getId(), division.getName(), division.getName());
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM subclass WHERE division_id = ?";
        this.jdbcTemplate.update(sql, id);

        sql = "DELETE FROM division WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean existsById(String id) {
        String sql = "SELECT count(*) FROM division WHERE id = ?";
        int count = this.jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        if (count == 0)
            return false;
        else
            return true;
    }
}
