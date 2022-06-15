package automatizado.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {

    protected WebDriver driver;

    protected BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTituloPaginaAtual(){
        return driver.getTitle().toLowerCase();
    }

}