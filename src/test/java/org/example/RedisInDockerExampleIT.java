package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
public class RedisInDockerExampleIT {
    private RedisBackedCache underTest;

    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:latest"))
            .withExposedPorts(6379);

    @BeforeEach
    public void setUp() {

        /*These code implementation is only required to test the method

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.environment().put("PATH", "c:\\windows\\system32\\");
        processBuilder.command("mspaint.exe");
        processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try {
            processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */

        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();
        // Assume that we have Redis running locally?
        //underTest = new RedisBackedCache("localhost", 6379);
        underTest = new RedisBackedCache(address, port);
    }
    @AfterEach
    void tearDown() {
        underTest.close();
    }


    @Test
    //@Disabled("Code is not implemented yet")
    void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        assertThat(retrieved).isEqualTo("example");
    }
}
