package automatizado.tests;

import automatizado.pages.GooglePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleTest extends BaseTests {

    private static GooglePage googlePage;

    @Before
    public void initTests(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePage(driver);
    }

    @Test
    public void TC01_devePesquisarNoGoogleTextoInformado(){
        googlePage.pesquisar("Coxinha de Frango");
        String resultado = googlePage.getResultadoPesquisa();
        Assert.assertTrue(resultado, resultado.contains("aproximadamente"));
    }

    @Test
    public void TC02_devePesquisarNoGoogleTextoInformado(){
        googlePage.pesquisar("Pastel de Camarão");
        String resultado = googlePage.getResultadoPesquisa();
        Assert.assertTrue(resultado, resultado.contains("resultados"));
    }
}
