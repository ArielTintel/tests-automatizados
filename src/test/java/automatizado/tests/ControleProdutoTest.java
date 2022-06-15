package automatizado.tests;

import automatizado.pages.ControleProdutoPage;
import automatizado.pages.LoginPage;
import automatizado.tests.config.DriverConfigs;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleProdutoTest extends DriverConfigs {

    private static LoginPage loginPage;
    private static ControleProdutoPage controleProdutoPage;

    @BeforeClass
    public static void initTests(){
        loginPage = new LoginPage(driver);
        loginPage.efetuarLogin("admin@admin.com", "admin");

        controleProdutoPage = new ControleProdutoPage(driver);
        Assert.assertEquals(controleProdutoPage.getTituloPaginaAtual(), "controle de produtos");
    }

    @Test
    public void TC01_deve_abrir_tela_cadastro_de_produtos(){
        controleProdutoPage.botaoCriarProduto.click();
        controleProdutoPage.botaoCriarProduto.click();

        String tituloModal = controleProdutoPage.tituloModalCriarProdutos.getText().toLowerCase();
        Assert.assertEquals(tituloModal, "produto");
    }

}
