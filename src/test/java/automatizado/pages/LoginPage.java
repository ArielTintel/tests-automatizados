package automatizado.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePO{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement campoEmail;

    @FindBy(id = "senha")
    private WebElement camposenha;

    @FindBy(id = "btn-entrar")
    private WebElement botaoEntrar;

    @FindBy(id = "mensagem")
    private WebElement mensagemDeErro;

    @FindBy(className = "close")
    private WebElement botaoFecharMensagemErro;

    public String getMensagem(){
        return mensagemDeErro.getText().toLowerCase();
    }

    public void digitar(WebElement campo, String texto){
        campo.clear();
        campo.sendKeys(texto, Keys.TAB);
    }

    public void efetuarLogin(String email, String senha) {
        digitar(campoEmail, email);
        digitar(camposenha, senha);
        botaoEntrar.click();
    }


}
