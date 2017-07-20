package com.tektrill.msg;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Collections;

/**
 * Created by isadsrj on 20/07/2017.
 */
//@Configuration
//@ConfigurationProperties(prefix = "activemq")
public class BrokerConfiguration {

	/**
	 * Defaults to TCP 10000
	 */
	private String connectorURI = "tcp://0.0.0.0:10000";
	private String kahaDBDataDir = "../../data/activemq";

	public String getConnectorURI() {
		return connectorURI;
	}

	public void setConnectorURI(String connectorURI) {
		this.connectorURI = connectorURI;
	}

	public String getKahaDBDataDir() {
		return kahaDBDataDir;
	}

	public void setKahaDBDataDir(String kahaDBDataDir) {
		this.kahaDBDataDir = kahaDBDataDir;
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public BrokerService broker() throws Exception {


		final BrokerService broker = new BrokerService();
	/*	KahaDBPersistenceAdapter persistenceAdapter = new KahaDBPersistenceAdapter();
		persistenceAdapter.setDirectory(new File(kahaDBDataDir));
		broker.addConnector(getConnectorURI());
		broker.setPersistent(true);
		broker.setPersistenceAdapter(persistenceAdapter);
		broker.setShutdownHooks(Collections.<Runnable> singletonList(new SpringContextHook()));
		broker.setUseJmx(false);

		final ManagementContext managementContext = new ManagementContext();
		managementContext.setCreateConnector(true);
		broker.setManagementContext(managementContext);
*/
		return broker;
	}
}