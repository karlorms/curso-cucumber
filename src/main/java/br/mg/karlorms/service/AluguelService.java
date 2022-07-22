package br.mg.karlorms.service;

import br.mg.karlorms.entidades.Filme;
import br.mg.karlorms.entidades.NotaAluguel;
import br.mg.karlorms.entidades.TipoAluguel;
import br.mg.karlorms.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoque!");

		NotaAluguel nota = new NotaAluguel();
		switch (tipo) {
		case COMUM:
			nota.setPreco(filme.getPrecoAluguel());
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			nota.setPontos(1);
			break;
			
		case EXTENDIDO:
			nota.setPreco(filme.getPrecoAluguel() * 2);
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			nota.setPontos(2);
			break;
			
		case SEMANAL:
			nota.setPreco(filme.getPrecoAluguel() * 3);
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
			nota.setPontos(3);
			break;
			
		default:
			break;
		}
		filme.diminuirEstoque();
		return nota;
	}

}
