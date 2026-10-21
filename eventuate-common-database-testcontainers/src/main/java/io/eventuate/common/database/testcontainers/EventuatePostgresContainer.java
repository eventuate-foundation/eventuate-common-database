package io.eventuate.common.database.testcontainers;

import io.eventuate.common.testcontainers.ContainerUtil;
import org.jspecify.annotations.NonNull;
import org.testcontainers.images.builder.ImageFromDockerfile;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class EventuatePostgresContainer extends AbstractEventuatePostgresContainer<EventuatePostgresContainer> {

    public EventuatePostgresContainer() {
        super(ContainerUtil.findImage("eventuateio/eventuate-postgres", "eventuate.common.database.version.properties"));
        withConfiguration();
    }

    public EventuatePostgresContainer(Path path) {
        super(new ImageFromDockerfile().withDockerfile(path));
        withConfiguration();
        ;
    }

    @NonNull
    static EventuatePostgresContainer makeFromDockerfile() {
        return new EventuatePostgresContainer(FileSystems.getDefault().getPath("../postgres/Dockerfile"));
    }

    static EventuatePostgresContainer make() {
      return new EventuatePostgresContainer();
    }

    @Override
    public String getEventuateDatabaseSchema() {
        return "eventuate";
    }

    @Override
    public String getMonitoringSchema() {
        return "eventuate";
    }
}
