package io.eventuate.common.database.jdbc;

public interface SqlJsonConverter {
  String convert(EventuateSchema schema, String column);
}
