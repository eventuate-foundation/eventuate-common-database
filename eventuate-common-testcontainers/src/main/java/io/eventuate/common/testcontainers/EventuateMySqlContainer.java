package io.eventuate.common.testcontainers;

import org.testcontainers.images.builder.ImageFromDockerfile;

import java.nio.file.Path;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class EventuateMySqlContainer extends AbstractEventuateMySqlContainer {

    public EventuateMySqlContainer() {
        super(ContainerUtil.findImage("eventuateio/eventuate-mysql8", "eventuate.common.version.properties"));
        withConfiguration();
    }

    public EventuateMySqlContainer(Path path) {
        super(new ImageFromDockerfile().withDockerfile(path));
        withConfiguration();
    }

}
