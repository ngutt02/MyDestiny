package com.pack;

//import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserAndAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAndAdminApplication.class, args);
	}
	/* @Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		return Server.createTcpServer(
				"-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}*/
	 
}
