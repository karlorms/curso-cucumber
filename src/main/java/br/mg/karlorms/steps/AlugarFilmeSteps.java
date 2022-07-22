package br.mg.karlorms.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import br.mg.karlorms.entidades.Filme;
import br.mg.karlorms.entidades.NotaAluguel;
import br.mg.karlorms.entidades.TipoAluguel;
import br.mg.karlorms.service.AluguelService;
import br.mg.karlorms.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AlugarFilmeSteps {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(int estoque) {
		filme = new Filme();
		filme.setEstoque(estoque);
	}

	@Dado("que o preco do aluguel seja R$ {int}")
	public void queOPrecoDoAluguelSejaR$(int preco) {
		filme.setPrecoAluguel(preco);
	}
	
	@Dado("um filme")
	public void umFilme(DataTable table) {
		Map<String, String> map = table.asMap(String.class, String.class);
		filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setPrecoAluguel(Integer.parseInt(map.get("preco")));
	}

	@Quando("alugar")
	public void alugar() {
		try {
			nota = aluguel.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}

	}

	@Entao("o preco do aluguel sera R$ {int}")
	public void oPrecoDoAluguelSera(Integer preco) {
		Assert.assertEquals(preco, Integer.valueOf(nota.getPreco()));
	}

	/*
	 * @Entao("a data de entrega sera no dia seguinte") public void
	 * aDataDeEntregaSeraNoDiaSeguinte() { Calendar cal = Calendar.getInstance();
	 * cal.add(Calendar.DAY_OF_MONTH, 1);
	 * 
	 * Date dataRetorno = nota.getDataEntrega(); Calendar calRetorno =
	 * Calendar.getInstance(); calRetorno.setTime(dataRetorno);
	 * 
	 * Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH),
	 * calRetorno.get(Calendar.DAY_OF_MONTH));
	 * Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
	 * Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR)); }
	 */
	@Entao("o estoque do filme sera {int} unidade")
	public void oEstoqueDoFilmeSeraUnidade(int int1) {
		Assert.assertEquals(int1, filme.getEstoque());
	}

	@Entao("nao sera possivel por falta de estoque")
	public void naoSeraPossivelPorFaltaDeEstoque() {
		Assert.assertEquals("Filme sem estoque!", erro);
	}

	@Dado("que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo){
		if (tipo.equals("semanal")) tipoAluguel = TipoAluguel.SEMANAL;
		if (tipo.equals("extendido")) tipoAluguel = TipoAluguel.EXTENDIDO;
		if (tipo.equals("comum")) tipoAluguel = TipoAluguel.COMUM;
	}

	@Entao("^a data de entrega sera em (\\d+) dias?$")
	public void adataDeEntregaSeraEmDias(Integer dias) {
		Date dataEsperada = DateUtils.obterDataDiferencaDias(dias);
		Date dataReal = nota.getDataEntrega();
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Entao("a pontuacao sera de (\\d+) pontos?$")
	public void aPontuacaoSeraDePontos(Integer pontos) {
		Assert.assertEquals(pontos, nota.getPontos());
	}

}
