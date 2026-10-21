package io.eventuate.common.database.testcontainers;

import java.util.function.Predicate;

public interface DatabaseContainerType {
  boolean supports(Predicate<String> isProfileActive);
  EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeVanillaContainer();
  String getDatabaseType();

  EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> make();

  EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeFromDockerfile();

  EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeVanillaContainerFromDockerfile();
}
