package gb.nabson.taxonomy.api.repository;

import gb.nabson.taxonomy.api.model.Subclass;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubclassRowMapper implements RowMapper {

    private final DivisionRowMapper divisionRowMapper;

    public SubclassRowMapper(DivisionRowMapper divisionRowMapper) {
        this.divisionRowMapper = divisionRowMapper;
    }


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subclass subclass = new Subclass();
        subclass.setId(rs.getString("id"));
        subclass.setName(rs.getString("name"));
        subclass.setDescription(rs.getString("description"));

        subclass.setDivision(this.divisionRowMapper.mapRow(rs, rowNum ));

        return subclass;
    }
}
