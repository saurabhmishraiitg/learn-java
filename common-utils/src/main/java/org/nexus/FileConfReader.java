package org.nexus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Read and load details from a config file
 * Config file location will be available in ENV variable, or
 * Use default Config file location ~/my-java-conf.yaml
 */
public class FileConfReader {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Will check if there is an ENV variable with name MY_JAVA_CONF exists or not.
     * Else will check for file ~/my-java-conf.yaml
     *
     * @return String
     */
    private static String getConfigFilePath() {
        String configFilePath = (System.getenv("MY_JAVA_CONF") != null) ? System.getenv("MY_JAVA_CONF") : System.getenv("HOME") +
                "/my-java-conf.yaml";
        LOG.info("configFilePath [{}]", configFilePath);
        return configFilePath;
    }

    /**
     * Load config file and return as MAP object.
     *
     * @return Map
     */
    public static Map<String, Object> loadConfig() {
        String configFilePath = getConfigFilePath();
        LOG.info("Loading Config from file [{}]", configFilePath);
        return readYAMLFile(configFilePath);
    }

    /**
     * Given a config file path, try to parse it as YAML
     *
     * @param confFilePath confFilePath
     */
    public static Map<String, Object> readYAMLFile(String confFilePath) {
        Yaml yaml = new Yaml();

        Map<String, Object> configMap = null;
        try (FileReader fr = new FileReader(confFilePath)) {
            configMap = yaml.load(fr);
            LOG.info("\nConfig File : [{}], \nConfig Map : \n{}", confFilePath, configMap);
        } catch (IOException fe) {
            LOG.error("File not found [{}]", confFilePath);
        }

        return configMap;
    }

//    public static void main(String[] args) {
//        readYAMLFile("sample-conf.yaml");
//    }
}
