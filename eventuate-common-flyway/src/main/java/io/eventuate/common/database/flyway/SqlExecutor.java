package io.eventuate.common.database.flyway;

import java.sql.SQLException;

interface SqlExecutor {
  void execute(String ddl) throws SQLException;
}
