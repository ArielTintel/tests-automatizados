package automatizado.pages;

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
    private WebElement mensagemErro;

    @FindBy(className = "close")
    private WebElement botaoFecharMensagemErro;

    public String getMensagem(){
        return mensagemErro.getText().toLowerCase();
    }

    public void efetuarLogin(String email, String senha) {
        digitar(campoEmail, email);
        digitar(camposenha, senha);
        botaoEntrar.click();
    }

}
