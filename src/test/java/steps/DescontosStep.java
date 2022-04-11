package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Dados;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import runner.RunCucumberTest;

import static org.openqa.selenium.By.id;


public class DescontosStep extends RunCucumberTest {

    HomePage HomePage = new HomePage(driver);

    @Dados("^que estou no site da qazando")
    public void acessar_site_qazando() throws InterruptedException {
        driver.manage().window().maximize();
        HomePage.acessarAplicacao();
        Assert.assertEquals("Acessou a aplicação!",true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());
    }

    @Quando("^eu preencho meu email$")
    public void eu_preencho_meu_email() throws InterruptedException{
        HomePage.scrollDown();
        HomePage.preencheEmail("yukiifullbuster@gmail.com");
    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom(){
        HomePage.cliqueGanharDesconto();
    }

    @Então("^eu vejo o código de desconto$")
    public void eu_vejo_o_código_de_desconto(){
        //# pra id e . pra select
        HomePage.verificarCupomDesconto();
    }

    @Dado("^que tenha cupom gerado")
    public void gerarCupom() throws InterruptedException {
        HomePage.acessarAplicacao();
        HomePage.scrollDown();
        HomePage.preencheEmail("yukiifullbuster@gmail.com");
        HomePage.cliqueGanharDesconto();
        HomePage.verificarCupomDesconto();
    }


}
