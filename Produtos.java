package MAPA;

public class Produtos {
	private String nome;
	private int precoUnitario;
	private String unidade;
	private int quantidadeEmEstoque;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPrecoUnitario(){
		return precoUnitario;
	}
	
	public void setPrecoUnitario(int precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	@Override
	public String toString() {
		return "NOME: " + nome + "\n" +
				"PRECO: " + precoUnitario + "\n" +
				"UNIDADE: " + unidade + "\n" +
				"QUANTIDADE: " + quantidadeEmEstoque + "\n";
	}
	
	public void setAdicionaQuantidade(int quantidade) {
		this.quantidadeEmEstoque += quantidade;
	}
	
	public void setSubtraiQuantidade(int quantidade) {
		this.quantidadeEmEstoque -= quantidade;
	}

}
