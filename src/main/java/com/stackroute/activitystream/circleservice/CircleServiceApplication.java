package com.stackroute.activitystream.circleservice;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages={"com.stackroute.activitystream.circleservice"})
public class CircleServiceApplication {
	

	@Bean  
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
        return hemf.getSessionFactory();  
    }

	public static void main(String[] args) {
		SpringApplication.run(CircleServiceApplication.class, args);
	}
}
