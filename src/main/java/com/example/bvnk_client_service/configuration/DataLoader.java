package com.example.bvnk_client_service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DataLoader implements CommandLineRunner {

	private final DataSource dataSource;

	@Value("${is.testing.enviroment}")
	private Boolean isTestingEnviroment;

	@Value("${demo.data.sql.name}")
	private String DEMO_DATA_SQL;

	@Autowired
	public DataLoader(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void run(String... args) throws Exception {
		if(isTestingEnviroment) {
			// Load and execute the demoData.sql script after Hibernate schema generation
			executeDataScript(DEMO_DATA_SQL);
		}
	}

	private void executeDataScript(String scriptPath) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			ScriptUtils.executeSqlScript(connection, new ClassPathResource(scriptPath));
		}
	}
}
