package automatizado.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTests {

    protected static WebDriver driver;

    private static final String URL_BASE = "file:///home/arieltintel/dev/projetos/automacao/tests-automatizados/src/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/driver/chromedriver";

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @After
    public void finalizar(){
        driver.quit();
    }

}
