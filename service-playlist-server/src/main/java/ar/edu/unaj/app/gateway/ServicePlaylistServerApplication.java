package ar.edu.unaj.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ServicePlaylistServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePlaylistServerApplication.class, args);
	}

}
