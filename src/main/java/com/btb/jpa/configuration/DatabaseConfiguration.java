package com.btb.jpa.configuration;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Profile;
        import org.springframework.jdbc.datasource.DriverManagerDataSource;
        import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
        import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

        import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    @Bean
    @Profile("localhost")
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/ams-short");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("12345678");
        return driverManagerDataSource;
    }

    @Bean
    @Profile("inMemory")
    DataSource inMemory(){
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        databaseBuilder.setType(EmbeddedDatabaseType.H2);
        return databaseBuilder.build();
    }
}
