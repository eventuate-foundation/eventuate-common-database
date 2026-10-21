package io.eventuate.common.database.jdbc;

import java.util.function.Supplier;

public interface EventuateTransactionTemplate {
  <T> T executeInTransaction(Supplier<T> callback);
}
