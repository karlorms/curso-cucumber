package br.mg.karlorms.entidades;

import java.util.Date;

public class NotaAluguel {
	
	private int preco;
	private Date dataEntrega;
	private Integer pontos;

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public Date getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(Date data) {
		this.dataEntrega = data;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	

}
