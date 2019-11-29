package ie.gmit.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserApiApplication extends Application<Configuration> {
		
	private static final Logger logger = LoggerFactory.getLogger(UserApiApplication.class);
	
	@Override
	public void initialize(Bootstrap<Configuration> b) {	
	}
	
	@Override
	public void run(Configuration config, Environment environment) throws Exception {
		logger.info("Resources REgistering");
		environment.jersey().register(new UserApiResources(environment.getValidator()));
		
		final ExampleHealthCheck healthCheck = new ExampleHealthCheck();
		environment.healthChecks().register("Example", healthCheck);
	}
	
	
	public static void main(String[] args) throws Exception {
		new UserApiApplication().run(args);
	}
	
	
}
