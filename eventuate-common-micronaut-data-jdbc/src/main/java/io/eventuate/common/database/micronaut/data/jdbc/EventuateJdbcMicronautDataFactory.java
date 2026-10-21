package io.eventuate.common.database.micronaut.data.jdbc;

import io.eventuate.common.database.jdbc.EventuateCommonJdbcStatementExecutor;
import io.eventuate.common.database.jdbc.EventuateJdbcStatementExecutor;
import io.eventuate.common.database.jdbc.EventuateTransactionTemplate;
import io.micronaut.context.annotation.Factory;
import io.micronaut.data.jdbc.runtime.JdbcOperations;

import jakarta.inject.Singleton;

@Factory
public class EventuateJdbcMicronautDataFactory {

  @Singleton
  public EventuateJdbcStatementExecutor eventuateCommonJdbcOperations(JdbcOperations jdbcOperations) {
    return new EventuateCommonJdbcStatementExecutor(jdbcOperations::getConnection);
  }

  @Singleton
  public EventuateTransactionTemplate eventuateTransactionTemplate(EventuateMicronautDataTransactionTemplate eventuateMicronautDataTransactionTemplate) {
    return eventuateMicronautDataTransactionTemplate;
  }
}
