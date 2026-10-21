package io.eventuate.common.database.testcontainers;

import io.eventuate.common.testcontainers.ContainerUtil;
import org.jspecify.annotations.NonNull;
import org.testcontainers.images.builder.ImageFromDockerfile;

import java.nio.file.Path;

public class EventuateMySqlContainer extends AbstractEventuateMySqlContainer<EventuateMySqlContainer> {

    public EventuateMySqlContainer() {
        super(ContainerUtil.findImage("eventuateio/eventuate-mysql8", "eventuate.common.database.version.properties"));
        withConfiguration();
    }

    public EventuateMySqlContainer(Path path) {
        super(new ImageFromDockerfile().withDockerfile(path));
        withConfiguration();
    }

  static EventuateMySqlContainer make() {
    return new EventuateMySqlContainer();
  }

  static @NonNull EventuateMySqlContainer makeFromDockerfile() {
    return new EventuateMySqlContainer(Path.of("../mysql/Dockerfile-mysql8"));
  }
}
