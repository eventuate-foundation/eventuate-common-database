package io.eventuate.common.testcontainers;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class EventuateDatabaseContainerImageTest {

    private final String version = System.getProperty("eventuate.common.database.version");

    @Test
    public void shouldWriteTheProjectVersionToTheVersionPropertiesFile() throws IOException {
        Properties props = new Properties();
        try (InputStream in = getClass().getResourceAsStream("/eventuate.common.database.version.properties")) {
            assertThat(in).isNotNull();
            props.load(in);
        }
        assertThat(props.getProperty("version")).isEqualTo(version);
    }

    // getDockerImageName() pulls the image, which is built locally only by the build-and-test scripts
    private String imageName(GenericContainer<?> container) {
        return container.withImagePullPolicy(imageName -> false).getDockerImageName();
    }

    @Test
    public void shouldUseTheImagesOfTheProjectVersion() {
        assertThat(imageName(new EventuateMySqlContainer()))
                .isEqualTo("eventuateio/eventuate-mysql8:" + version);
        assertThat(imageName(new EventuatePostgresContainer()))
                .isEqualTo("eventuateio/eventuate-postgres:" + version);
        assertThat(imageName(new EventuateVanillaMySqlContainer()))
                .isEqualTo("eventuateio/eventuate-vanilla-mysql8:" + version);
        assertThat(imageName(new EventuateVanillaPostgresContainer()))
                .isEqualTo("eventuateio/eventuate-vanilla-postgres:" + version);
    }
}
