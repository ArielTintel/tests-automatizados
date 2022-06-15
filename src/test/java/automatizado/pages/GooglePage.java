package automatizado.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePO {

    @FindBy(name = "q")
    public WebElement barraDePesquisas;

    @FindBy(id = "result-stats")
    public WebElement resultadoDePesquisas;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void pesquisar(String textoPesquisa){
        barraDePesquisas.clear();
        barraDePesquisas.sendKeys(textoPesquisa, Keys.ENTER);
    }

    public String getResultadoPesquisa(){
        return resultadoDePesquisas.getText().toLowerCase();
    }

}
