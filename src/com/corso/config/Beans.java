package com.corso.config;

import javax.sql.DataSource;

import com.corso.dao.*;
import com.corso.dao.impl.*;
import com.corso.service.*;
import com.corso.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration   /*qui ci cono le istanze da creare e gestire con il container di Spring DI-IoC*/
@ComponentScan(basePackages="com.corso")

@EnableTransactionManagement /* Abilita la gestione delle transazioni */

public class Beans {

    private static String dbName = "checkstring";
    private static String dburl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false";
    private static String dbuser = "root";
    private static String dbpass = "";

	@Bean(name="dataSource")
    public DataSource getDataSource () {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername(dbuser);
        ds.setPassword(dbpass);
        ds.setUrl(dburl);
        return ds;
    }


	@Bean
    public LocalContainerEntityManagerFactoryBean  getEntityManager(){

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        // factory.setValidationMode(ValidationMode.AUTO);

        // JDBC
        factory.setDataSource(getDataSource());

        // imposta il dialogo tra JPA e hibernate
        factory.setJpaVendorAdapter(getJpaVendorAdapter()); // imposta il dialogo tra JPA e hibernate

        // impostare il luogo dove si trovano le entity con il mapping
        factory.setPackagesToScan("com.corso.model");
        return factory;
    }

    private HibernateJpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);   // obbligatorio: serve per tradurre le query nel particolare Dialetto

        adapter.setGenerateDdl(true);          //facoltativo, attiva il DDL cio� hibernate creer� le strutture nel DB se non sono gi� essitenti
        adapter.setShowSql(true);              // mostra l'SQL, comodo per i corsi e per il debug ma in produzione solitamente � a false
        return adapter;
    }

    /*** transazioni ***/
    @Bean
    public PlatformTransactionManager getTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        //transactionManager.setEntityManagerFactory(getEntityManager().getObject());
        //transactionManager.setNestedTransactionAllowed(false);
        return transactionManager;
    }


    /**** sezione DAO ****/

    @Bean(name="paesiDAO")
    public PaesiDAO getPaesiDao (){
        PaesiDAO dao = new PaesiDAOimpl();
        return dao;
    }

    @Bean(name="rankingAlgoritmiDAO")
    public RankingAlgoritmiDAO getRankingAlgoritmiDao (){
        RankingAlgoritmiDAO dao = new RankingAlgoritmiDAOimpl();
        return dao;
    }

    @Bean(name="ricercheRecentiDAO")
    public RicercheRecentiDAO getRicercheRecentiDao (){
        RicercheRecentiDAO dao = new RicercheRecentiDAOimpl();
        return dao;
    }

    @Bean(name="sigleSpecialiDAO")
    public SigleSpecialiDAO getSigleSpecialiDao (){
        SigleSpecialiDAO dao = new SigleSpecialiDAOimpl();
        return dao;
    }


    /**** sezione Service ****/

    @Bean(name="paesiService")
    public PaesiService getCategoriaService (){
        PaesiService service = new PaesiServiceImpl();
        service.setDao(getPaesiDao());
        return service;
    }

    @Bean(name="paesiService")
    public RankingAlgoritmiService getRankingAlgoritmiService (){
        RankingAlgoritmiService service = new RankingAlgoritmiServiceImpl();
        service.setDao(getRankingAlgoritmiDao());
        return service;
    }

    @Bean(name="ricercheRecentiService")
    public RicercheRecentiService getRicercheRecentiService (){
        RicercheRecentiService service = new RicercheRecentiServiceImpl();
        service.setDao(getRicercheRecentiDao());
        return service;
    }

    @Bean(name="sigleSpecialiService")
    public SigleSpecialiService getSigleSpecialiService (){
        SigleSpecialiService service = new SigleSpecialiServiceImpl();
        service.setDao(getSigleSpecialiDao());
        return service;
    }
}