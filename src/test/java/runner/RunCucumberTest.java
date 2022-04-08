package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //configurações do report de teste. Existem dois: um gerado pelo cucumber, básico
        //E outro que criamos quando rodamos o teste pelo terminal. Relatórios diferentes
        plugin = {},
        //Caminho dos arquivos .features (BDDs)
        features = "D:/Meus Documentos/Arquivos/CursoAutomacaoTestes/src/test/resources/features",
        //Caso queira rodar cenarios especificos, colocar a tag e os que tiverem ela, rodarão
        //quando coloca '~' na frente, é o diferente, tudo que não ter a tag, rodará
        tags = {"~@ignore"},
        //Caminho de onde estão os aquivos dos metodos (STEPs)
        glue = {"steps"}
)
public class RunCucumberTest {

}
