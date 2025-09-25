import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
	
	private DSL dsl;

	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	//Escreve um texto no imput de Nome
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	} 
	
	//Escreve um texto no input de sobrenome
	public void setSobreNome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	//Seta o radio de sexo como masculino
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	//Seta o checkbox de comida favorita como Pizza
	public void setComidaFavoritaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");	
	}

	//Seta escolaridade de acordo com o valor recebido
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);	
	}
	
	//Seta esrpote de acordo com o valor seleiconado
	public void setEsporte(String valor) {
		dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	//Escreve um texto no textField de Sugestão
	public void setSugestao(String valor) {
		dsl.escrever("elementosForm:sugestoes", valor);
	}
	
	//Clica no botão de cadastrar
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
}
	
