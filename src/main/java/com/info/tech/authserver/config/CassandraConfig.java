package com.info.tech.authserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = {"com.zensar.humane.authserver.repository" }, cassandraTemplateRef = "cassandraTemplate")
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keySpace;

	@Value("${spring.data.cassandra.contact-points}")
	private String contactPoints;

	@Value("${spring.data.cassandra.port}")
	private int port;

	@Value("${spring.data.cassandra.username}")
	private String userName;

	@Value("${spring.data.cassandra.password}")
	private String password;

	@Value("${spring.data.cassandra.local-datacenter}")
	private String localDataCenter;

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	public String getLocalDataCenter() {
		return localDataCenter;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.NONE;
	}

	@Override
	protected String getKeyspaceName() {
		return this.keySpace;
	}

	@Bean("cassandraSession")
	public CqlSessionFactoryBean session() {
		final CqlSessionFactoryBean session = super.cassandraSession();
		session.setKeyspaceName(getKeyspaceName());
		session.setContactPoints(getContactPoints());
		session.setPort(getPort());
		session.setUsername(this.userName);
		session.setPassword(this.password);
		session.setLocalDatacenter(getLocalDataCenter());

		return session;
	}

	@Bean("cassandraTemplate")
	public CassandraAdminOperations cassandraTemplate(final CqlSessionFactoryBean session) throws Exception {
		return new CassandraAdminTemplate(session.getObject(), cassandraConverter());
	}

}
