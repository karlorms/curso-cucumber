package br.mg.karlorms.entidades;

public class Filme {
	private Integer estoque;
	private int valor;
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public void setPrecoAluguel(int valor) {
		this.valor = valor;
	}
	
	public int getPrecoAluguel() {
		return valor;
	}
	
	public void diminuirEstoque() {
		this.estoque --;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
}
