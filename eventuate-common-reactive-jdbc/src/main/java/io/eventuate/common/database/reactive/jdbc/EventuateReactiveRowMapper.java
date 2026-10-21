package io.eventuate.common.database.reactive.jdbc;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.util.function.BiFunction;

public interface EventuateReactiveRowMapper<T> extends BiFunction<Row, RowMetadata, T> {
}
