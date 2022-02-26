package OnlyMusic.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import OnlyMusic.Model.Administrator;

/**
 * This class is used by JDBC objects to map administrator attributes 
 */



public class AdministratorRowMapper implements RowMapper<Administrator>{
	
	//Customer object row-mapper
		@Override
		public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {
			// create customer object and set it's attribute values
			Administrator administrator = new Administrator();
			administrator.setName(rs.getString("name"));
			administrator.setAdminId(rs.getLong("adminId"));
			administrator.setPassword(rs.getNString("password"));
			administrator.setContactNumber(rs.getLong("contactNumber"));
			administrator.setContactEmail(rs.getString("contactEmail"));
			administrator.setRole();
			return administrator;
		}

}
