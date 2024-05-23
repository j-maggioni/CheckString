package com.corso.config;

import com.corso.dao.GiocoDAO;
import com.corso.dao.UtenteDAO;
import com.corso.dao.impl.GiocoDAOimpl;
import com.corso.dao.impl.UtenteDAOimpl;
import com.corso.service.GiocoService;
import com.corso.service.UtenteService;
import com.corso.service.impl.GiocoServiceImpl;
import com.corso.service.impl.UtenteServiceImpl;
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

import javax.sql.DataSource;


@Configuration   /*qui ci cono le istanze da creare e gestire con il container di Spring DI-IoC*/
@ComponentScan(basePackages="com.corso")

@EnableTransactionManagement /* Abilita la gestione delle transazioni */

public class Beans1 {

    private static String dbName = "utenti";
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

    @Bean(name="utenteDAO")
    public UtenteDAO getUtenteDAO(){
        UtenteDAO dao = new UtenteDAOimpl();
        return dao;
    }

    @Bean(name="giocoDAO")
    public GiocoDAO getGiocoDAO(){
        GiocoDAO dao = new GiocoDAOimpl();
        return dao;
    }

    /**** sezione Service ****/

    @Bean(name="utenteService")
    public UtenteService getUtenteService(){
        UtenteService service = new UtenteServiceImpl();
        service.setDao(getUtenteDAO());
        return service;
    }

    @Bean(name="giocoService")
    public GiocoService getGiocoService(){
        GiocoService service = new GiocoServiceImpl();
        service.setDao(getGiocoDAO());
        return service;
    }

}