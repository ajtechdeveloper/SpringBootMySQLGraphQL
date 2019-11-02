package com.aj.springbootmysqlgraphql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMySQLGraphQLApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootMySQLGraphQLApplication.class);

    public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootMySQLGraphQLApplication.class,args);
	}
}
