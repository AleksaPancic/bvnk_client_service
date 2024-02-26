package com.example.bvnk_client_service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DataLoader implements CommandLineRunner {

	private final DataSource dataSource;

	@Autowired
	public DataLoader(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void run(String... args) throws Exception {
		// Load and execute the demoData.sql script after Hibernate schema generation
		executeDataScript("demoData.sql");
	}

	private void executeDataScript(String scriptPath) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			ScriptUtils.executeSqlScript(connection, new ClassPathResource(scriptPath));
		}
	}
}
