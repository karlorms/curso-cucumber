package br.mg.karlorms.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.mg.karlorms.converters.DataConverter;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AprenderCucumberSteps {	
	
	@Dado("que criei o arquivo corretamente")
	public void queCrieiOArquivoCorretamente() {
		System.out.println("passou dado");
	}

	@Quando("executa-lo")
	public void executaLo() {

	}

	@Entao("a especificacao deve finalizar com sucesso")
	public void aEspecificacaoDeveFinalizarComSucesso() {

	}

	private Integer contador = 0;

	@Dado("que o valor do contador e {int}")
	public void queOValorDoContadorE(Integer int1) {
		contador = int1;
	}

	@Quando("eu incrementar em {int}")
	public void euIncrementarEm(Integer int1) {
		contador += int1;
	}

	@Entao("o valor do contador sera {int}")
	public void oValorDoContadorSera(Integer int1) {
		System.out.println(int1);
		System.out.println(contador);
		// Assert.assertTrue(int1 == contador);
		Assert.assertEquals(int1, contador);
	}

	Date entrega = new Date();

	@Dado("que a entrega e dia (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void queAEntregaEDia(String value) {
		DataConverter dc = new DataConverter();
		entrega = dc.converterDate(value);
		System.out.println("Entrega!!!" + entrega);
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(Integer int1, String tempo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, int1);
		}
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, int1);
		}
		entrega = cal.getTime();
	}

	Date data = new Date();

	@Entao("a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeraEfetuadaEm(String data) throws Throwable {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = df.format(entrega);
		Assert.assertEquals(data, dataFormatada);
		System.out.println(df.format(entrega));

		/*
		 * Calendar cal = Calendar.getInstance(); cal.setTime(data);
		 * cal.set(Calendar.DAY_OF_MONTH, dia); cal.set(Calendar.MONTH, mes);
		 * cal.set(Calendar.YEAR, ano); data = cal.getTime(); Assert.assertEquals(data,
		 * entrega); DateFormat sdf = new SimpleDateFormat("yy/MM/yyyy");
		 */
	}

	/////////////////////////////////////////////////////////////////////////////////////////////


	@Dado("que o ticket( especial)? e A.(\\d{3})$")
	public void queOTicketEAF(String especial, String ticket) {
	}

	@Dado("que o valor da passagem e R\\$ (.*)$")
	public void queOValorDaPassagemER$(Double valor) {
		System.out.println(valor);
	}

	@Dado("que o nome do passageiro e \"(.{5,20})\"$")
	public void queONomeDoPassageiroE(String passageiro) {
	}

	@Dado("que o telefone do passageiro e (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroE(String fone) {
	}

	@Quando("criar os steps")
	public void criarOsSteps() {
	}

	@Entao("o teste vai funcionar")
	public void oTesteVaiFuncionar() {
	}

}
