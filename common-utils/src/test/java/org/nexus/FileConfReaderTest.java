package org.nexus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileConfReaderTest {
    private static final Logger LOG = LogManager.getLogger();

    @BeforeEach
    void setUp() {
        LOG.debug("@Setup - executes once before all test methods in this class");
    }

    @AfterEach
    void tearDown() {
        LOG.debug("@TearDown - executed after all test method.");
    }

    @DisplayName("Check for a config value")
    @Test
    void readYAMLFile() throws NullPointerException {
        URL resURL = getClass().getClassLoader().getResource("sample-conf.yaml");

        assert resURL != null;
        LOG.info("Trying to read YAML config file [{}]", resURL.getFile());
        Map<String, Object> configMap = FileConfReader.readYAMLFile(resURL.getFile());

        assertEquals("Saurabh", configMap.get("name"), "Name is not matching!!!");
    }

    @DisplayName("Test if Load Config is Successful")
    @Disabled("Requires ENV or Home path file to run")
    @Test
    void loadConfig() {
        LOG.info("Trying to load config file");
        Map<String, Object> configMap = FileConfReader.loadConfig();

        assertEquals("Saurabh", configMap.get("name"), "Name is not matching!!!");
    }
}
