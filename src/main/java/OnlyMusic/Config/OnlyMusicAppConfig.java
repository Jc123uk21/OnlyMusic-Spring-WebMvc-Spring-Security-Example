package OnlyMusic.Config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import OnlyMusic.DAO.AdministratorDao;
import OnlyMusic.DAO.AdministratorDaoImpl;
import OnlyMusic.DAO.CustomerDao;
import OnlyMusic.DAO.CustomerDaoImpl;
import OnlyMusic.DAO.TrackDao;
import OnlyMusic.DAO.TrackDaoImpl;
import OnlyMusic.Model.Administrator;
import OnlyMusic.Model.Customer;
import OnlyMusic.Model.Track;
import OnlyMusic.Services.AdministratorService;
import OnlyMusic.Services.AdministratorServiceImpl;
import OnlyMusic.Services.CustomerService;
import OnlyMusic.Services.CustomerServiceImp;
import OnlyMusic.Services.TrackService;
import OnlyMusic.Services.TrackServiceImpl;



// Class containing the project's configuration details, static content, handles bean creations, database connection details etc

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "OnlyMusic" })
public class OnlyMusicAppConfig implements WebMvcConfigurer {

	// Configure internal view resolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	//Configure static contents location
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	
	}

	// Configure JDBCTemplate
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	// set up data source
	@Bean
	public DataSource dataSource() {
		// create new datasource object
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//set datasource connection attributes
		dataSource.setUsername("username");
		dataSource.setPassword("paasword");
		dataSource.setUrl("jdbc:mysql://localhost:3306/onlymusic?useSSl=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	
	//Create new Customer object bean for AutoWire
	@Bean
	public Customer customer() {
		Customer customer = new Customer();
		return customer;
	}
	
	//Create new Track object bean for AutoWire
	@Bean
	public Track track() {
		Track track = new Track();
		return track;
	}
	
	//Create new Administrator object bean for AutoWire
	@Bean Administrator admin() {
		return new Administrator();
	}
	
	//Create a BCrypt password encoder to handle passwords
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Create new AdministratorService bean for AutoWire 
	@Bean
	public AdministratorService adminService() {
		AdministratorService adminService = new AdministratorServiceImpl();
		return adminService;
	}
	
	
	//Create new CustomerService bean for AutoWire
	@Bean
	public CustomerService customerService() {
		CustomerService customerService = new CustomerServiceImp();
		return customerService;
	}
	
	//Create new AdministratorDao object for AutoWire
	@Bean
	public AdministratorDao adminDao() {
		return new AdministratorDaoImpl();
	}
	
	//Create new CustomerDao object for AutoWire
	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoImpl();
	}
	
	//Create new TrackDao object for AutoWire
	@Bean
	public TrackDao trackDao() {
		return new TrackDaoImpl();
	}
	
	//Create new TrackService object for AutoWire
	@Bean
	public TrackService trackService() {
		return new TrackServiceImpl();
	}

}
