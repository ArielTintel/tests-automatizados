package automatizado.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePO {

    @FindBy(name = "q")
    public WebElement barraPesquisas;

    @FindBy(id = "result-stats")
    public WebElement resultadoPesquisas;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void pesquisar(String textoPesquisa){
        barraPesquisas.clear();
        barraPesquisas.sendKeys(textoPesquisa, Keys.ENTER);
    }

    public String getResultadoPesquisa(){
        return resultadoPesquisas.getText().toLowerCase();
    }

}
