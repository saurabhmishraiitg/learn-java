package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

class AppTest {

    private static final Logger LOG = LogManager.getLogger();

    @BeforeAll
    static void setup() {
        LOG.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        LOG.info("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    void tearDown() {
        LOG.info("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        LOG.info("@AfterAll - executed after all test methods.");
    }

    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        LOG.info("Success");
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
    }
}