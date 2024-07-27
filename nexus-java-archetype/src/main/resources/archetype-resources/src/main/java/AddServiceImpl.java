package $package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddServiceImpl implements AddService {

    private static final Logger LOG = LogManager.getLogger();

    @Override
    public int add(int num1, int num2) {
        LOG.info("AddServiceImpl add executed");
        return num1 + num2;
    }
}
