package $package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalcService {

    private AddService addService;
    private static final Logger LOG = LogManager.getLogger();

    public CalcService(AddService addService) {
        this.addService = addService;
    }

    public int calc(int num1, int num2) {
        LOG.info("CalcService calc executed");
        return addService.add(num1, num2);
    }

}
