package automatizado.tests.config;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class DriverConfigs {

    protected static WebDriver driver;

    private static final String URL_BASE = "file:///home/arieltintel/dev/projetos/QA/tests-automatizados/src/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/driver/chromedriver";
    
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass
    public static void finalizar(){
        driver.quit();
    }

}
