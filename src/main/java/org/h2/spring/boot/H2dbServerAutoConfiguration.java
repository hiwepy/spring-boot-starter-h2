package org.h2.spring.boot;

import java.sql.SQLException;

import org.h2.server.web.WebServlet;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

/**
 * 
 */
@Configuration
@ConditionalOnClass(org.h2.Driver.class)
@ConditionalOnProperty(prefix = H2dbServerProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ H2dbServerProperties.class })
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class H2dbServerAutoConfiguration implements ResourceLoaderAware {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private ResourceLoader resourceLoader;
	
	@Autowired
	private H2dbServerProperties properties;
	
	/*<bean id = "org.h2.tools.Server"
            class="org.h2.tools.Server"
            factory-method="createTcpServer"
            init-method="start"
            destroy-method="stop">
	    <constructor-arg value="-tcp,-tcpAllowOthers,-tcpPort,8043" />
	</bean>*/

	

	/* 使用H2控制台的Servlet H2控制台是一个独立的应用程序，包括它自己的Web服务器，但它可以作为一个servlet作为   */
	public ServletRegistrationBean<WebServlet> h2WebServer() {
		
		/*<servlet>
		    <servlet-name>H2Console</servlet-name>
		    <servlet-class>org.h2.server.web.WebServlet</servlet-class>
		    <init-param>
		        <param-name>webAllowOthers</param-name>
		        <param-value></param-value>
		    </init-param>
		    <init-param>
		        <param-name>trace</param-name>
		        <param-value></param-value>
		    </init-param>
		    <load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping>
		    <servlet-name>H2Console</servlet-name>
		    <url-pattern>/console</url-pattern>
		</servlet-mapping> */
		
		ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<WebServlet>();
		
		registration.setServlet(new WebServlet());
		registration.addUrlMappings("/console/*");
		
		return registration;
	}
	
	/*
    @Bean  
    @ConditionalOnExpression("${h2.web.enabled:true}")  
    public Server h2WebServer() throws SQLException {  
    	
    	
        return Server.createWebServer("-webAllowOthers", "-webPort", h2WebPort).start();  
    }  */
    /*<servlet>  
	    <description>注册H2数据库的扩展函数</description>  
	    <servlet-name>RegisterH2DBExtFunction</servlet-name>  
	    <servlet-class>me.gacl.sys.init.RegisterH2ExtFuncServlet</servlet-class>  
	    <!--   
	    1、load-on-startup元素标记容器是否在启动的时候就加载这个servlet(实例化并调用其init()方法)。  
	    2、它的值必须是一个整数，表示servlet应该被载入的顺序  
	    3、当值为0或者大于0时，表示容器在应用启动时就加载并初始化这个servlet；  
	    4、当值小于0或者没有指定时，则表示容器在该servlet被选择时才会去加载。  
	    5、正数的值越小，该servlet的优先级越高，应用启动时就越先加载。  
	    6、当值相同时，容器就会自己选择顺序来加载。  
	    所以，<load-on-startup>x</load-on-startup>，中x的取值1，2，3，4，5代表的是优先级，而非启动延迟时间。  
	     -->  
	     <load-on-startup>1</load-on-startup>  
	</servlet>  */
	 	
	/**
	 * @return
	 * @throws SQLException
	 * @see {@link Server#main(String...)}}
	 */
	@Bean  
    @ConditionalOnExpression("${h2.tcp.enabled:false}")  
    public Server h2TcpServer() throws SQLException {  
		
        return Server.createTcpServer("-tcpAllowOthers", "-tcpPort", properties.getTcpPort()).start();  
    }  
  
	    
	public Server tcpServer() throws SQLException {
		
		Server server = Server.createPgServer("-tcpAllowOthers", "-tcpPort", properties.getTcpPort()); 
		
		server.start();
		
		server.stop();
		
		return server;
	}
	 

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

}
