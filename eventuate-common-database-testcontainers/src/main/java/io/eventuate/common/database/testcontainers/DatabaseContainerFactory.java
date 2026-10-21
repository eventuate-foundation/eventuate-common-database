package io.eventuate.common.database.testcontainers;

import static io.eventuate.common.database.testcontainers.DatabaseContainerTypeRegistry.findDatabaseContainerType;

public class DatabaseContainerFactory {

  public static EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeDatabaseContainer() {
    return findDatabaseContainerType().make();
  }

  public static EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeVanillaDatabaseContainer() {
    return findDatabaseContainerType().makeVanillaContainer();
  }

  public static EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeDatabaseContainerFromDockerFile() {
    return findDatabaseContainerType().makeFromDockerfile();
  }

  public static EventuateDatabaseContainer<? extends EventuateDatabaseContainer<?>> makeVanillaDatabaseContainerFromDockerFile() {
    return findDatabaseContainerType().makeVanillaContainerFromDockerfile();
  }


  public static String getDatabaseType() {
    return findDatabaseContainerType().getDatabaseType();
  }
}
