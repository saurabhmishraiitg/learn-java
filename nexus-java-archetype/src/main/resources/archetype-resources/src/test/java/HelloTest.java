package $package;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class HelloTest {

    private static final Logger LOG = LogManager.getLogger();
    CalcService calcService;
    private AutoCloseable closeable;

    @Mock
    AddService addService;

    @BeforeAll
    static void setup() {
        LOG.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        LOG.info("@BeforeEach - executes before each test method in this class");
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        LOG.info("@AfterEach - executed after each test method.");
        closeable.close();
    }

    @AfterAll
    static void done() {
        LOG.info("@AfterAll - executed after all test methods.");
    }

    @DisplayName("GetName Test")
    @Test
    void getName() {
        String name = "Nexus";
        Hello hello = new Hello();
        assertEquals(name, hello.getName(name));
    }

    @DisplayName("TestCalc Test")
    @Test
    public void testCalc() {
        LOG.info("Test testCalc executed");

        calcService = new CalcService(addService);

        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        when(addService.add(num1, num2)).thenReturn(expected);

        int actual = calcService.calc(num1, num2);

        assertEquals(expected, actual);

    }
}