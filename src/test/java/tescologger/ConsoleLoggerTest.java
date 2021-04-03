package tescologger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by sudhirkumar on 9/19/17.
 */
public class ConsoleLoggerTest {
    AbstractLogger logger = LoggerFactory.getLogger("CONSOLE");
    AbstractLogger fileLogger = LoggerFactory.getLogger("Next");

    @Before
    public void getLoggerChain() {
        logger.setNextLogger(fileLogger);
    }

    @Test
    public void checkLogLevel() throws Exception {

        logger.logMessage(3, "Heelllloo..");
        logger.logMessage(3, "Try..");

        Assert.assertEquals(logger.level , 1);
        Assert.assertEquals(fileLogger.level, 3);
        Assert.assertEquals(logger.nextLogger, fileLogger);

    }

    @Test
    public void write_integrationTest() throws Exception {

        logger.logMessage(3, "Heelllloo..");
        logger.logMessage(3, "Try..");

        File f = new File("fileA.txt");
        Assert.assertEquals(f.exists(), true);

        f.delete();
        Assert.assertEquals(f.exists(), false);

    }
}