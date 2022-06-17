package automatizado.tests;

import automatizado.pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTests {

    private static final String MENSAGEM_ERRO_CAMPO_VAZIO = "informe usuário e senha, os campos não podem ser brancos.";
    private static final String MENSAGEM_ERRO_EMAIL_OU_SENHA = "e-mail ou senha inválidos";

    private static LoginPage loginPage;

    @Before
    public void init(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void TC01_nao_deve_logar_no_sistema_com_email_e_senha_vazios(){
        loginPage.efetuarLogin("", "");
        String mensagemErro = loginPage.getMensagem();

        Assert.assertTrue(mensagemErro, mensagemErro.contains("não podem ser brancos"));
        Assert.assertEquals(mensagemErro, MENSAGEM_ERRO_CAMPO_VAZIO);
    }

    @Test
    public void TC02_nao_deve_logar_no_sistema_com_email_invalido_e_senha_vazia(){
        loginPage.efetuarLogin("invalido@admin.com", "");
        String mensagemErro = loginPage.getMensagem();

        Assert.assertTrue(mensagemErro, mensagemErro.contains("não podem ser brancos"));
        Assert.assertEquals(mensagemErro, MENSAGEM_ERRO_CAMPO_VAZIO);
    }

    @Test
    public void TC03_nao_deve_logar_no_sistema_com_email_vazio_e_senha_invalida(){
        loginPage.efetuarLogin("", "SenhaInvalida");
        String mensagemErro = loginPage.getMensagem();

        Assert.assertTrue(mensagemErro, mensagemErro.contains("não podem ser brancos"));
        Assert.assertEquals(mensagemErro, MENSAGEM_ERRO_CAMPO_VAZIO);
    }

    @Test
    public void TC04_nao_deve_logar_no_sistema_com_email_e_senha_invalidos(){
        loginPage.efetuarLogin("invalido@admin.com", "SenhaInvalida");
        String mensagemErro = loginPage.getMensagem();

        Assert.assertTrue(mensagemErro, mensagemErro.contains("inválidos"));
        Assert.assertEquals(mensagemErro, MENSAGEM_ERRO_EMAIL_OU_SENHA);
    }

    @Test
    public void TC05_nao_deve_logar_no_sistema_com_senha_invalida(){
        loginPage.efetuarLogin("admin@admin.com", "SenhaInvalida");
        String mensagemErro = loginPage.getMensagem();

        Assert.assertTrue(mensagemErro, mensagemErro.contains("inválidos"));
        Assert.assertEquals(mensagemErro, MENSAGEM_ERRO_EMAIL_OU_SENHA);
    }

    @Test
    public void TC06_nao_deve_logar_no_sistema_com_email_invalido(){
        loginPage.efetuarLogin("invalido@admin.com", "admin");
        String mensagemErro = loginPage.getMensagem();

        Assert.assertTrue(mensagemErro, mensagemErro.contains("inválidos"));
        Assert.assertEquals(mensagemErro, MENSAGEM_ERRO_EMAIL_OU_SENHA);
    }

    @Test
    public void TC07_deve_efetuar_login_corretamente_no_sistema(){
        loginPage.efetuarLogin("admin@admin.com", "admin");
        String tituloDaPagina = loginPage.getTituloPaginaAtual();

        Assert.assertTrue(tituloDaPagina, tituloDaPagina.contains("produtos"));
        Assert.assertEquals(tituloDaPagina, "controle de produtos");
    }

}
