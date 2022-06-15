package automatizado.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleProdutoPage extends BasePO{

    public ControleProdutoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn-adicionar")
    public WebElement botaoCriarProduto;

    @FindBy(className = "nav-link")
    public WebElement botaoVoltar;

    @FindBy(className = "modal-title")
    public WebElement tituloModalCriarProdutos;




}
