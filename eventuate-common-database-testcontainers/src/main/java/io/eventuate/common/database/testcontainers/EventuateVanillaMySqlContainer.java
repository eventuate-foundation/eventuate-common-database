package io.eventuate.common.database.testcontainers;

import io.eventuate.common.testcontainers.ContainerUtil;
import org.testcontainers.images.builder.ImageFromDockerfile;

import java.nio.file.Path;

public class EventuateVanillaMySqlContainer extends AbstractEventuateMySqlContainer<EventuateVanillaMySqlContainer> {

    public EventuateVanillaMySqlContainer() {
        super(ContainerUtil.findImage("eventuateio/eventuate-vanilla-mysql8", "eventuate.common.database.version.properties"));
        withConfiguration();
    }

    public EventuateVanillaMySqlContainer(Path path) {
        super(new ImageFromDockerfile().withDockerfile(path));
        withConfiguration();
    }

    protected static EventuateVanillaMySqlContainer make() {
      return new EventuateVanillaMySqlContainer();
    }

    public static EventuateVanillaMySqlContainer makeFromDockerfile() {
      return new EventuateVanillaMySqlContainer(Path.of("../mysql/Dockerfile-vanilla-mysql8"));
    }

}
