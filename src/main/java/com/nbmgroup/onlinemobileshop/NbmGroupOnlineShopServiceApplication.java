package com.nbmgroup.onlinemobileshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.nbmgroup.onlinemobileshop.repository")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class NbmGroupOnlineShopServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbmGroupOnlineShopServiceApplication.class, args);
	}

}