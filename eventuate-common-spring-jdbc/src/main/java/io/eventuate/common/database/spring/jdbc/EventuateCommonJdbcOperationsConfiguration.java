package io.eventuate.common.database.spring.jdbc;

import io.eventuate.common.database.jdbc.EventuateCommonJdbcOperations;
import io.eventuate.common.database.jdbc.EventuateJdbcOperationsUtils;
import io.eventuate.common.database.jdbc.EventuateJdbcStatementExecutor;
import io.eventuate.common.database.jdbc.OutboxPartitioningSpec;
import io.eventuate.common.database.jdbc.sqldialect.EventuateSqlDialect;
import io.eventuate.common.database.jdbc.sqldialect.SqlDialectSelector;
import io.eventuate.common.database.spring.jdbc.sqldialect.SqlDialectConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Import({EventuateSchemaConfiguration.class,
        SqlDialectConfiguration.class,
        EventuateTransactionTemplateConfiguration.class})
public class EventuateCommonJdbcOperationsConfiguration {


  @Autowired(required = false)
  private OutboxPartitioningSpec outboxPartitioningSpec = OutboxPartitioningSpec.DEFAULT;

  @Bean
  public EventuateJdbcStatementExecutor eventuateJdbcStatementExecutor(JdbcTemplate jdbcTemplate) {
    return new EventuateSpringJdbcStatementExecutor(jdbcTemplate);
  }

  @Bean
  public EventuateCommonJdbcOperations eventuateCommonJdbcOperations(EventuateJdbcStatementExecutor eventuateJdbcStatementExecutor,
                                                                     SqlDialectSelector sqlDialectSelector,
                                                                     @Value("${spring.datasource.driver-class-name}") String driver) {
    EventuateSqlDialect eventuateSqlDialect = sqlDialectSelector.getDialect(driver);

    return new EventuateCommonJdbcOperations(new EventuateJdbcOperationsUtils(eventuateSqlDialect),
            eventuateJdbcStatementExecutor, eventuateSqlDialect, outboxPartitioningSpec);
  }
}
