package com.zplus.schoolmaster.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class configuration {
    @Bean
    SessionFactory sessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
    {

        return  hibernateEntityManagerFactory.getSessionFactory();
    }
}
