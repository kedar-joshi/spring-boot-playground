package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = { "classpath:config/applicationContext.xml" })
public class ContextConfiguration
{
	private static final Logger logger = LogManager.getLogger(ContextConfiguration.class);

}
