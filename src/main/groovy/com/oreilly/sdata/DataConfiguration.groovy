package com.oreilly.sdata

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

/**
 * Created by oo185005 on 12/30/16.
 */
@Configuration
@EnableJpaRepositories('com.oreilly.sdata')
@EnableTransactionManagement
@ComponentScan('com.oreilly.sdata')
class DataConfiguration {

    @Bean
    DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
        builder.type = EmbeddedDatabaseType.H2
        builder.build()
    }

    @Bean
    EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter()
        vendorAdapter.generateDdl = true

        Properties jpaProperties = new Properties().with {
            put('hibernate.hbm2ddl.auto', 'create-drop')
            put('hibernate.hbm2ddl.import_files', 'init.sql')
            put('hibernate.dialect', 'org.hibernate.dialect.HSQLDialect')

            it
        }

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean()
        factoryBean.dataSource = dataSource()
        factoryBean.packagesToScan = ['com.oreilly.sdata']
        factoryBean.jpaVendorAdapter = vendorAdapter
        factoryBean.jpaProperties = jpaProperties

        factoryBean.afterPropertiesSet()

        factoryBean.object
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        new JpaTransactionManager().with {
            entityManagerFactory = entityManagerFactory()

            it
        }
    }
}
