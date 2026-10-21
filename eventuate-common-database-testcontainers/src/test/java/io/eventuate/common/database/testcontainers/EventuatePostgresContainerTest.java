package io.eventuate.common.database.testcontainers;

import io.eventuate.common.testcontainers.PropertyProvidingContainer;
import io.eventuate.common.database.jdbc.EventuateSchema;
import io.eventuate.common.database.spring.jdbc.EventuateCommonJdbcOperationsConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(classes = EventuatePostgresContainerTest.Config.class)
public class EventuatePostgresContainerTest {

    public static EventuateDatabaseContainer<?> database = EventuatePostgresContainer.makeFromDockerfile();

    @DynamicPropertySource
    static void registerMySqlProperties(DynamicPropertyRegistry registry) {
        PropertyProvidingContainer.startAndProvideProperties(registry, database);
    }


    @Configuration
    @EnableAutoConfiguration
    @Import(EventuateCommonJdbcOperationsConfiguration.class)
    public static class Config {
    }


    @Autowired
    private EventuateSchema eventuateSchema;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void shouldSpecifyEventuateSchema() {
        jdbcTemplate.queryForList("select * from %s".formatted(eventuateSchema.qualifyTable("message")));
    }

    @Test
    public void shouldSpecifyMonitoringSchema() {
        jdbcTemplate.queryForList("select * from %s.cdc_monitoring".formatted(database.getMonitoringSchema()));
    }

}