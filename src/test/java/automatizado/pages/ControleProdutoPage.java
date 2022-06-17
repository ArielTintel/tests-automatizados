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
    public WebElement tituloTelaCriarProdutos;

    @FindBy(id = "codigo")
    public WebElement campoCodigoTelaCadastros;

    @FindBy(id = "nome")
    public WebElement campoNomeTelaCadastros;

    @FindBy(id = "quantidade")
    public WebElement campoQuantidadeTelaCadastros;

    @FindBy(id = "valor")
    public WebElement campoValorTelaCadastros;

    @FindBy(id = "data")
    public WebElement campoDataTelaCadastros;

    @FindBy(id = "btn-salvar")
    public WebElement botaoSalvarTelaCadastros;

    @FindBy(id = "btn-sair")
    public WebElement botaoSairTelaCadastros;

    @FindBy(id = "mensagem")
    public WebElement mensagemErroTelaCadastros;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[1]")
    private WebElement codigoProdutoCadastrado;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement nomeProdutoCadastrado;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[3]")
    private WebElement quantidadeProdutoCadastrado;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[4]")
    private WebElement valorProdutoCadastrado;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr[1]/td[5]")
    private WebElement dataProdutoCadastrado;

    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data) {
        digitar(campoCodigoTelaCadastros, codigo);
        digitar(campoNomeTelaCadastros, nome);
        digitar(campoQuantidadeTelaCadastros, (quantidade != null) ? quantidade.toString() : "");
        digitar(campoValorTelaCadastros, (valor != null) ? valor.toString() : "");
        digitar(campoDataTelaCadastros, data);
        botaoSalvarTelaCadastros.click();
    }

    public String getTituloTelaCriarProdutos(){
        return tituloTelaCriarProdutos.getText();
    }

    public String getMensagemErroTelaCadastros(){
        return mensagemErroTelaCadastros.getText();
    }

    public String getCodigoProduto(){
        return codigoProdutoCadastrado.getText();
    }
    public String getNomeProduto(){
        return nomeProdutoCadastrado.getText();
    }
    public String getQuantidadeProduto(){
        return quantidadeProdutoCadastrado.getText();
    }
    public String getValorProduto(){
        return valorProdutoCadastrado.getText();
    }
    public String getDataProduto(){
        return dataProdutoCadastrado.getText();
    }

}
