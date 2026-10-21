package io.eventuate.common.database.inmemorydatabase;

import java.util.List;
import java.util.function.Supplier;

public interface EventuateDatabaseScriptSupplier extends Supplier<List<String>> {
}
