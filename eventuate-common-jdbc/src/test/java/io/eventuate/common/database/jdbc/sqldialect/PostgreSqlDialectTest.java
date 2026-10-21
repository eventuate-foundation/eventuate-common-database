package io.eventuate.common.database.jdbc.sqldialect;

import java.util.Optional;

public class PostgreSqlDialectTest extends AbstractDialectTest {

  public PostgreSqlDialectTest() {
    super("postgresql",
            "org.postgresql.Driver",
            PostgresDialect.class,
            "(ROUND(EXTRACT(EPOCH FROM CURRENT_TIMESTAMP) * 1000))",
            Optional.empty());
  }
}
