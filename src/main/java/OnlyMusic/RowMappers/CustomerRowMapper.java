package OnlyMusic.RowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import OnlyMusic.Model.Customer;

/**
 * This Class is used by JDBC to map Customer object attributes 
* */

public class CustomerRowMapper implements RowMapper<Customer>{

	//Customer object row-mapper
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// create customer object and set it's attribute values
		Customer customer = new Customer();
		customer.setCustomerEmail(rs.getString("customerEmail"));
		customer.setPassword(rs.getString("password"));
		customer.setCustomerAddress(rs.getString("customerAddress"));
		customer.setCustomerDOB(rs.getDate("customerDOB"));
		customer.setCustomerId(rs.getLong("customerId"));
		customer.setRole();
		return customer;
	}

}
