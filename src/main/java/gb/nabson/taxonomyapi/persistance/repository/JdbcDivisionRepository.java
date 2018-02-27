package gb.nabson.taxonomyapi.persistance.repository;


import gb.nabson.taxonomyapi.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary  // use @Qualifier("DivisionRepositoryBlah") in constructor to override)
public class JdbcDivisionRepository implements DivisionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcDivisionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
    public long count() {
        String sql = "SELECT COUNT(*) FROM division";
        RowMapper<Long> rowMapper = new BeanPropertyRowMapper<>(Long.class);
        return jdbcTemplate.queryForObject(sql,rowMapper );
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
