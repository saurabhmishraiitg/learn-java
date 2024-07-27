package $package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hello {

    private static final Logger LOG = LogManager.getLogger();
    public static void main(String[] args) {
        LOG.info("Hello World");
    }

    public String getName(String name) {
        return name;
    }
}
