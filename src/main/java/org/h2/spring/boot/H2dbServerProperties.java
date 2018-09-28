package org.h2.spring.boot;

import java.util.NoSuchElementException;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(H2dbServerProperties.PREFIX)
public class H2dbServerProperties {

	public static final String PREFIX = "h2.server";

	// type of server
	public enum Protocol {

		HTTP(0), TCP(1), PG(2);

		private final int protocol;

		Protocol(int protocol) {
			this.protocol = protocol;
		}

		public int get() {
			return protocol;
		}

		public boolean equals(Protocol protocol) {
			return this.compareTo(protocol) == 0;
		}

		public boolean equals(int protocol) {
			return this.compareTo(Protocol.valueOfIgnoreCase(protocol)) == 0;
		}

		public static Protocol valueOfIgnoreCase(int key) {
			for (Protocol protocol : Protocol.values()) {
				if (protocol.get() == key) {
					return protocol;
				}
			}
			throw new NoSuchElementException("Cannot found Protocol with key '" + key + "'.");
		}

	}

	/** Whether Enable H2 Server. */
	private boolean enabled = false;

	/**
	 * H2 Server 服务类型；
	 * <p> HTTP（Start the web server with the H2 Console ）, </p>
	 * <p> TCP（Start the TCP server ）, </p>
	 * <p> PG（Start the PG server） </p>
	 */
	private Protocol protocol = Protocol.HTTP;

	/** TCP port for remote connections(default: 9092) */
	private String tcpPort = "9092";
	/** Whether Allow other computers to connect */
	protected boolean tcpAllowOthers;
	/** Whether Use a daemon thread */
	protected boolean tcpDaemon;
	/** Whether Use encrypted (SSL) connections */
	protected boolean tcpSSL;
	/** The password for shutting down a TCP server */
	private String tcpPassword;
	/** The url for Stop the TCP server; example: tcp://localhost */
	private String tcpShutdown;
	/** Whether Do not wait until all connections are closed */
	protected boolean tcpShutdownForce;

	/** The Web port (default: 8082) */
	private String webPort = "8082";
	/** Whether Use encrypted (HTTPS) connections */
	protected boolean webSSL;
	/** Whether Allow other computers to connect */
	protected boolean webAllowOthers;
	/** Whether Use a daemon thread */
	protected boolean webDaemon;
	/** Whether Start a browser connecting to the web server */
	protected boolean browser;

	/** The PG port (default: 5435) */
	private String pgPort = "5435";
	/** Whether Allow other computers to connect */
	protected boolean pgAllowOthers;
	/** Whether Use a daemon thread */
	protected boolean pgDaemon;

	/** The dir of Server properties (default: ~, disable: null) */
	protected boolean properties;
	/** HyperSQL Server 外部配置文件；如 ： classpath:hsql.properties */
	protected String props;
	/** The base directory for H2 databases (all servers) */
	private String baseDir = "";
	/** Allows to map a database name to another (all servers) */
	private String key;
	/** Whether Print additional trace information (all servers) */
	protected boolean trace = false;
	/** Whether Only existing databases may be opened (all servers) */
	protected boolean ifExists;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public String getTcpPort() {
		return tcpPort;
	}

	public void setTcpPort(String tcpPort) {
		this.tcpPort = tcpPort;
	}

	public boolean isTcpAllowOthers() {
		return tcpAllowOthers;
	}

	public void setTcpAllowOthers(boolean tcpAllowOthers) {
		this.tcpAllowOthers = tcpAllowOthers;
	}

	public boolean isTcpDaemon() {
		return tcpDaemon;
	}

	public void setTcpDaemon(boolean tcpDaemon) {
		this.tcpDaemon = tcpDaemon;
	}

	public boolean isTcpSSL() {
		return tcpSSL;
	}

	public void setTcpSSL(boolean tcpSSL) {
		this.tcpSSL = tcpSSL;
	}

	public String getTcpPassword() {
		return tcpPassword;
	}

	public void setTcpPassword(String tcpPassword) {
		this.tcpPassword = tcpPassword;
	}

	public String getTcpShutdown() {
		return tcpShutdown;
	}

	public void setTcpShutdown(String tcpShutdown) {
		this.tcpShutdown = tcpShutdown;
	}

	public boolean isTcpShutdownForce() {
		return tcpShutdownForce;
	}

	public void setTcpShutdownForce(boolean tcpShutdownForce) {
		this.tcpShutdownForce = tcpShutdownForce;
	}

	public String getWebPort() {
		return webPort;
	}

	public void setWebPort(String webPort) {
		this.webPort = webPort;
	}

	public boolean isWebSSL() {
		return webSSL;
	}

	public void setWebSSL(boolean webSSL) {
		this.webSSL = webSSL;
	}

	public boolean isWebAllowOthers() {
		return webAllowOthers;
	}

	public void setWebAllowOthers(boolean webAllowOthers) {
		this.webAllowOthers = webAllowOthers;
	}

	public boolean isWebDaemon() {
		return webDaemon;
	}

	public void setWebDaemon(boolean webDaemon) {
		this.webDaemon = webDaemon;
	}

	public boolean isBrowser() {
		return browser;
	}

	public void setBrowser(boolean browser) {
		this.browser = browser;
	}

	public String getPgPort() {
		return pgPort;
	}

	public void setPgPort(String pgPort) {
		this.pgPort = pgPort;
	}

	public boolean isPgAllowOthers() {
		return pgAllowOthers;
	}

	public void setPgAllowOthers(boolean pgAllowOthers) {
		this.pgAllowOthers = pgAllowOthers;
	}

	public boolean isPgDaemon() {
		return pgDaemon;
	}

	public void setPgDaemon(boolean pgDaemon) {
		this.pgDaemon = pgDaemon;
	}

	public boolean isProperties() {
		return properties;
	}

	public void setProperties(boolean properties) {
		this.properties = properties;
	}

	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isTrace() {
		return trace;
	}

	public void setTrace(boolean trace) {
		this.trace = trace;
	}

	public boolean isIfExists() {
		return ifExists;
	}

	public void setIfExists(boolean ifExists) {
		this.ifExists = ifExists;
	}

}