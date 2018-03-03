package gb.nabson.taxonomy.api.repository;


import gb.nabson.taxonomy.api.model.Division;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRowMapper implements RowMapper {
    @Override
    public Division mapRow(ResultSet rs, int rowNum) throws SQLException {
        Division division = new Division();

        division.setId(rs.getString("division_id"));
        division.setName(rs.getString("division_name"));
        division.setDescription(rs.getString("division_description"));
        return division;
    }
}
