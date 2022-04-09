package steps;

import cucumber.api.java.pt.Dados;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import runner.RunCucumberTest;

import static org.openqa.selenium.By.id;


public class DescontosStep extends RunCucumberTest {

    @Dados("^que estou no site da qazando")
    public void acessar_site_qazando() throws InterruptedException {
        driver.get("https://qazando.com.br/curso.html");
        driver.manage().window().maximize();

        Assert.assertEquals("Acessou a aplicação!",true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed());

    }

    @Quando("^eu preencho meu email$")
    public void eu_preencho_meu_email() throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(id("email")).sendKeys("yukiifullbuster@gmail.com");

    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom(){
        // Write code here that turns the phrase above into concrete action
        driver.findElement(id("button")).click();

    }

    @Então("^eu vejo o código de desconto$")
    public void eu_vejo_o_código_de_desconto(){
        // Write code here that turns the phrase above into concrete actions
        //# pra id e . pra select
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        Assert.assertEquals("Cupom correto!!","QAZANDO15OFF", texto_cupom);
    }


}
