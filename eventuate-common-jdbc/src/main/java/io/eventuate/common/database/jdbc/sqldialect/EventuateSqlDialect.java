package io.eventuate.common.database.jdbc.sqldialect;

import io.eventuate.common.database.jdbc.EventuateJdbcStatementExecutor;
import io.eventuate.common.database.jdbc.EventuateSchema;
import io.eventuate.common.database.jdbc.SchemaAndTable;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public interface EventuateSqlDialect extends EventuateSqlDialectOrder {
  boolean supports(String driver);
  boolean accepts(String name);

  String getCurrentTimeInMillisecondsExpression();

  String addLimitToSql(String sql, String limitExpression);

  String addReturningOfGeneratedIdToSql(String sql, String idColumn);

  default String castToJson(String sqlPart,
                            EventuateSchema eventuateSchema,
                            String unqualifiedTable,
                            String column,
                            BiFunction<String, List<Object>, List<Map<String, Object>>> selectCallback) {
    return sqlPart;
  }

  default String jsonColumnToString(Object object,
                                    EventuateSchema eventuateSchema,
                                    String unqualifiedTable,
                                    String column,
                                    EventuateJdbcStatementExecutor eventuateJdbcStatementExecutor) {
    return object.toString();
  }

  List<String> getPrimaryKeyColumns(DataSource dataSource, String dataSourceUrl, SchemaAndTable schemaAndTable) throws SQLException;
}
