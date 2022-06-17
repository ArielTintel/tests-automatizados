package automatizado.tests;

import automatizado.build.ProdutoBuilder;
import automatizado.pages.ControleProdutoPage;
import automatizado.pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleProdutoTest extends BaseTests {

    private static final String MENSAGEM_ERRO_TELA_CADASTROS = "Todos os campos são obrigatórios para o cadastro!";

    private static LoginPage loginPage;
    private static ControleProdutoPage controleProdutoPage;

    @Before
    public void initLogin(){
        loginPage = new LoginPage(driver);
        loginPage.efetuarLogin("admin@admin.com", "admin");

        controleProdutoPage = new ControleProdutoPage(driver);
        Assert.assertEquals(controleProdutoPage.getTituloPaginaAtual(), "controle de produtos");
    }

    //TODO: Deve-se corrigir BUG que precisa clicar duas vezes no botao de CRIAR(cadastrar produtos)
    // ao efetuar Login pela primeira vez.
    @Test
    public void TC01_deve_abrir_tela_para_cadastro_de_produtos(){
        controleProdutoPage.botaoCriarProduto.click();
        controleProdutoPage.botaoCriarProduto.click();

        String tituloModal = controleProdutoPage.getTituloTelaCriarProdutos();
        Assert.assertEquals(tituloModal, "Produto");
    }

    @Test
    public void TC02_nao_deve_cadastrar_produto_sem_preencher_todos_os_campos(){
        controleProdutoPage.botaoCriarProduto.click();
        controleProdutoPage.botaoCriarProduto.click();

        controleProdutoPage.cadastrarProduto("", "Cadeira", null, null, "");

        String mensagemErro = controleProdutoPage.getMensagemErroTelaCadastros();
        Assert.assertEquals(MENSAGEM_ERRO_TELA_CADASTROS, mensagemErro);
    }

    @Test
    public void TC03_nao_deve_cadastrar_produto_sem_preencher_um_dos_campos(){
        controleProdutoPage.botaoCriarProduto.click();
        controleProdutoPage.botaoCriarProduto.click();

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        produtoBuilder.setCodigo("");
        produtoBuilder.builder();
        Assert.assertEquals(MENSAGEM_ERRO_TELA_CADASTROS, controleProdutoPage.mensagemErroTelaCadastros.getText());

        produtoBuilder.setCodigo("0001");
        produtoBuilder.setNome("");
        produtoBuilder.builder();
        Assert.assertEquals(MENSAGEM_ERRO_TELA_CADASTROS, controleProdutoPage.mensagemErroTelaCadastros.getText());

        produtoBuilder.setNome("Cadeira");
        produtoBuilder.setQuantidade(null);
        produtoBuilder.builder();
        Assert.assertEquals(MENSAGEM_ERRO_TELA_CADASTROS, controleProdutoPage.mensagemErroTelaCadastros.getText());

        produtoBuilder.setQuantidade(10);
        produtoBuilder.setValor(null);
        produtoBuilder.builder();
        Assert.assertEquals(MENSAGEM_ERRO_TELA_CADASTROS, controleProdutoPage.mensagemErroTelaCadastros.getText());

        produtoBuilder.setValor(29.99);
        produtoBuilder.setData("");
        produtoBuilder.builder();
        Assert.assertEquals(MENSAGEM_ERRO_TELA_CADASTROS, controleProdutoPage.mensagemErroTelaCadastros.getText());
    }

    @Test
    public void TC04_deve_cadastrar_produtos_e_fechar_tela_cadastros_de_produtos(){
        controleProdutoPage.botaoCriarProduto.click();
        controleProdutoPage.botaoCriarProduto.click();

        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        produtoBuilder.setCodigo("01");
        produtoBuilder.setNome("Smart TV");
        produtoBuilder.setQuantidade(10);
        produtoBuilder.setValor(3999.99);
        produtoBuilder.setData("01/06/2022");
        produtoBuilder.builder();
        controleProdutoPage.botaoSairTelaCadastros.click();

        Assert.assertEquals("01", controleProdutoPage.getCodigoProduto());
        Assert.assertEquals("Smart TV", controleProdutoPage.getNomeProduto());
        Assert.assertEquals("10", controleProdutoPage.getQuantidadeProduto());
        Assert.assertEquals("3999.99", controleProdutoPage.getValorProduto());
        Assert.assertEquals("2022-06-01", controleProdutoPage.getDataProduto());
    }

}
